package com.learning.concepts.cache;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;

/**
 * A fixed-capacity, thread-safe Least Recently Used (LRU) cache.
 *
 * <p>This implementation is backed by {@link LinkedHashMap} configured with
 * {@code accessOrder=true}. In access-order mode, entries are re-ordered when they are read or
 * updated, so the iteration order is from least recently used (LRU) to most recently used (MRU).
 *
 * <p>When an insertion causes the size to exceed {@code capacity}, exactly one eldest entry
 * (the current LRU entry) is evicted.
 *
 * <h3>Design notes</h3>
 * <ul>
 *   <li>Average-time complexity for {@code get}, {@code put}, {@code remove}, and
 *       {@code containsKey} is O(1).</li>
 *   <li>Thread-safety is provided via a single {@link ReentrantLock} protecting all map access.</li>
 *   <li>Null keys and null values are rejected to avoid ambiguous cache-miss semantics.</li>
 *   <li>An optional eviction callback is invoked after the lock is released to avoid long lock
 *       hold times when handlers are slow.</li>
 * </ul>
 *
 * @param <K> key type
 * @param <V> value type
 */
public final class LruCache<K, V> {

    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final LinkedHashMap<K, V> map;
    private final BiConsumer<K, V> onEvict;

    /**
     * Creates an LRU cache with no-op eviction handling.
     *
     * @param capacity maximum number of entries this cache can hold; must be greater than zero
     * @throws IllegalArgumentException if {@code capacity <= 0}
     */
    public LruCache(int capacity) {
        this(capacity, (k, v) -> { });
    }

    /**
     * Creates an LRU cache with a custom eviction callback.
     *
     * <p>The callback runs only when an insertion triggers eviction due to capacity overflow.
     * It is not called for explicit removals via {@link #remove(Object)} or {@link #clear()}.
     *
     * @param capacity maximum number of entries this cache can hold; must be greater than zero
     * @param onEvict callback receiving evicted key/value pairs; must not be {@code null}
     * @throws IllegalArgumentException if {@code capacity <= 0}
     * @throws NullPointerException if {@code onEvict} is {@code null}
     */
    public LruCache(int capacity, BiConsumer<K, V> onEvict) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        this.capacity = capacity;
        this.onEvict = Objects.requireNonNull(onEvict, "onEvict must not be null");

        // accessOrder=true => get/put moves entry to most recently used end
        this.map = new LinkedHashMap<>(Math.min(capacity, 1024), 0.75f, true);
    }

    /**
     * Returns the value for {@code key}, if present.
     *
     * <p>For existing keys, this read updates recency and moves the entry toward MRU position.
     *
     * @param key key to look up; must not be {@code null}
     * @return the cached value, or {@code null} if the key is not present
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public V get(K key) {
        Objects.requireNonNull(key, "key must not be null");
        lock.lock();
        try {
            return map.get(key);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts or updates a cache entry.
     *
     * <p>If {@code key} already exists, the old value is replaced and the key becomes most recently
     * used. If this call grows the cache beyond capacity, one LRU entry is evicted and passed to
     * the eviction callback.
     *
     * @param key key to insert/update; must not be {@code null}
     * @param value value to associate with {@code key}; must not be {@code null}
     * @return the previous value associated with {@code key}, or {@code null} if none existed
     * @throws NullPointerException if {@code key} or {@code value} is {@code null}
     */
    public V put(K key, V value) {
        Objects.requireNonNull(key, "key must not be null");
        Objects.requireNonNull(value, "value must not be null");

        Map.Entry<K, V> evicted = null;
        lock.lock();
        try {
            V previous = map.put(key, value);

            // Manual eviction keeps callback control explicit.
            if (map.size() > capacity) {
                Map.Entry<K, V> eldest = map.entrySet().iterator().next();
                K evictedKey = eldest.getKey();
                V evictedValue = eldest.getValue();
                map.remove(evictedKey);
                evicted = new AbstractMap.SimpleImmutableEntry<>(evictedKey, evictedValue);
            }
            return previous;
        } finally {
            lock.unlock();
            // Call callback outside lock to avoid lock contention from slow handlers.
            if (evicted != null) {
                onEvict.accept(evicted.getKey(), evicted.getValue());
            }
        }
    }

    /**
     * Removes {@code key} from the cache if present.
     *
     * @param key key to remove; must not be {@code null}
     * @return the removed value, or {@code null} if the key was absent
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public V remove(K key) {
        Objects.requireNonNull(key, "key must not be null");
        lock.lock();
        try {
            return map.remove(key);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Checks whether the cache currently contains {@code key}.
     *
     * <p>This method does not alter recency order.
     *
     * @param key key to test; must not be {@code null}
     * @return {@code true} if present, otherwise {@code false}
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public boolean containsKey(K key) {
        Objects.requireNonNull(key, "key must not be null");
        lock.lock();
        try {
            return map.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns the current number of entries.
     *
     * @return the cache size
     */
    public int size() {
        lock.lock();
        try {
            return map.size();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Removes all entries from the cache.
     *
     * <p>No eviction callbacks are emitted for entries removed by this method.
     */
    public void clear() {
        lock.lock();
        try {
            map.clear();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an immutable snapshot of current entries in LRU to MRU iteration order.
     *
     * <p>The returned map is detached from internal state, so subsequent cache mutations do not
     * affect the snapshot.
     *
     * @return unmodifiable copy of cache contents in LRU -> MRU order
     */
    public Map<K, V> snapshot() {
        lock.lock();
        try {
            return Collections.unmodifiableMap(new LinkedHashMap<>(map));
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(3,
                (k, v) -> System.out.println("Evicted: " + k + "=" + v));

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1);      // marks key 1 as most recently used
        cache.put(4, "D"); // evicts key 2

        cache.get(3);      // marks key 3 as most recently used
        cache.put(5, "E"); // evicts key 1

        System.out.println(cache.snapshot());
        // Expected keys present: 3, 4, 5 (order shown by map implementation)
    }
}
