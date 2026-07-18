package com.learning.concepts.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Interview-friendly LRU cache example using {@link LinkedHashMap}.
 *
 * <p>This file demonstrates the most concise production-acceptable pattern for implementing a
 * fixed-size LRU cache in Java:
 * <ol>
 *   <li>Enable access-order in {@link LinkedHashMap}.</li>
 *   <li>Override {@code removeEldestEntry(...)} to auto-evict the eldest.</li>
 * </ol>
 *
 * <p>With {@code accessOrder=true}, iteration order is maintained from least recently used (LRU)
 * to most recently used (MRU). Any successful {@code get} or {@code put} on an existing key moves
 * that entry to MRU position.
 *
 * <p>Complexity (average): {@code get/put/remove/containsKey} are O(1). Eviction decision is also
 * O(1) because it only checks current size and lets {@link LinkedHashMap} remove the eldest node.
 */
public class LruCacheInterviewExample {

    /**
     * Simple fixed-size LRU cache.
     *
     * <p>This implementation is intentionally minimal to make interview explanation easy. Since it
     * extends {@link LinkedHashMap}, all standard map operations are available directly.
     *
     * @param <K> cache key type
     * @param <V> cache value type
     */
    static class SimpleLruCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        /**
         * Creates a fixed-size LRU cache.
         *
         * @param capacity max entries allowed; must be greater than zero
         * @throws IllegalArgumentException if {@code capacity <= 0}
         */
        SimpleLruCache(int capacity) {
            super(capacity, 0.75f, true);
            if (capacity <= 0) {
                throw new IllegalArgumentException("capacity must be > 0");
            }
            this.capacity = capacity;
        }

        /**
         * Called by {@link LinkedHashMap} after each insertion.
         *
         * <p>Returning {@code true} instructs the map to remove the current eldest entry. In
         * access-order mode, eldest means LRU.
         *
         * @param eldest eldest entry candidate
         * @return {@code true} when current size exceeds capacity, otherwise {@code false}
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    /**
     * Small walkthrough demonstrating LRU ordering and automatic eviction.
     *
     * <p>Expected progression:
     * <ol>
     *   <li>{@code {1=A, 2=B, 3=C}}</li>
     *   <li>{@code get(1)} moves key 1 to MRU -&gt; {@code {2=B, 3=C, 1=A}}</li>
     *   <li>{@code put(4, D)} evicts LRU key 2 -&gt; {@code {3=C, 1=A, 4=D}}</li>
     *   <li>{@code get(3)} then {@code put(5, E)} evicts LRU key 1 -&gt; {@code {4=D, 3=C, 5=E}}</li>
     * </ol>
     *
     * @param args unused
     */
    public static void main(String[] args) {
        SimpleLruCache<Integer, String> cache = new SimpleLruCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("After 3 puts: " + cache); // {1=A, 2=B, 3=C}

        cache.get(1); // access key 1 -> key 1 becomes MRU
        System.out.println("After get(1): " + cache); // {2=B, 3=C, 1=A}

        cache.put(4, "D"); // capacity exceeded -> evicts LRU key 2
        System.out.println("After put(4, D): " + cache); // {3=C, 1=A, 4=D}

        cache.get(3); // key 3 becomes MRU
        cache.put(5, "E"); // evicts LRU key 1
        System.out.println("After put(5, E): " + cache); // {4=D, 3=C, 5=E}
    }
}

