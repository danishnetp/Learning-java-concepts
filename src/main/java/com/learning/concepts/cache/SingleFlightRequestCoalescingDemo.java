package com.learning.concepts.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Interview-friendly Request Coalescing (Single-Flight) demo.
 *
 * <p>Problem: If many threads request the same missing key at the same time, each thread might
 * call the backend loader, causing duplicate expensive work (cache stampede).
 *
 * <p>Solution (single-flight):
 * <ol>
 *   <li>Keep one in-flight future per key.</li>
 *   <li>First caller creates and starts the load.</li>
 *   <li>Other callers for that same key wait on the same future.</li>
 *   <li>When loading finishes, all waiters receive the same result.</li>
 * </ol>
 *
 * <p>This version is intentionally small and easy to explain in interviews.
 */
public final class SingleFlightRequestCoalescingDemo {

    /**
     * Minimal single-flight cache with request coalescing.
     *
     * <p>The cache has two maps:
     * <ul>
     *   <li>{@code cache}: stores completed values.</li>
     *   <li>{@code inFlight}: stores active loads so concurrent callers share one load.</li>
     * </ul>
     *
     * @param <K> key type
     * @param <V> value type
     */
    public static final class SingleFlightCache<K, V> {

        private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
        private final ConcurrentHashMap<K, CompletableFuture<V>> inFlight = new ConcurrentHashMap<>();
        private final Executor loaderExecutor;

        /**
         * Creates a cache that executes loads on the provided executor.
         *
         * @param loaderExecutor executor used to run load operations
         * @throws NullPointerException if {@code loaderExecutor} is null
         */
        public SingleFlightCache(Executor loaderExecutor) {
            this.loaderExecutor = Objects.requireNonNull(loaderExecutor, "loaderExecutor must not be null");
        }

        /**
         * Returns cached value for {@code key}, or coalesces concurrent loads for that key.
         *
         * <p>Behavior:
         * <ul>
         *   <li>If value exists in cache, return immediately.</li>
         *   <li>If load is already in progress for this key, wait for that same load.</li>
         *   <li>Otherwise start one new load, publish it in {@code inFlight}, and let others join.</li>
         * </ul>
         *
         * <p>Important: If loader fails, all waiting callers see the same failure.
         *
         * @param key key to fetch
         * @param loader function that computes value when missing
         * @return value for key
         * @throws NullPointerException if key or loader is null, or if loader returns null
         * @throws RuntimeException if loader throws an exception
         */
        public V getOrLoad(K key, Function<K, V> loader) {
            Objects.requireNonNull(key, "key must not be null");
            Objects.requireNonNull(loader, "loader must not be null");

            V cachedValue = cache.get(key);
            if (cachedValue != null) {
                return cachedValue;
            }

            CompletableFuture<V> myFuture = new CompletableFuture<>();
            CompletableFuture<V> existing = inFlight.putIfAbsent(key, myFuture);
            CompletableFuture<V> sharedFuture = existing != null ? existing : myFuture;

            if (existing == null) {
                loaderExecutor.execute(() -> {
                    try {
                        V loaded = Objects.requireNonNull(loader.apply(key), "loader returned null");
                        cache.put(key, loaded);
                        myFuture.complete(loaded);
                    } catch (Throwable t) {
                        myFuture.completeExceptionally(t);
                    } finally {
                        inFlight.remove(key, myFuture);
                    }
                });
            }

            try {
                return sharedFuture.join();
            } catch (CompletionException e) {
                throw unwrapAsRuntime(e);
            }
        }

        /**
         * Invalidates one key from completed cache entries.
         *
         * <p>Does not cancel any currently in-flight load.
         *
         * @param key key to invalidate
         */
        public void invalidate(K key) {
            cache.remove(key);
        }

        /**
         * Clears all completed cache entries.
         *
         * <p>Does not cancel any currently in-flight loads.
         */
        public void clear() {
            cache.clear();
        }

        private RuntimeException unwrapAsRuntime(CompletionException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            if (cause instanceof RuntimeException) {
                return (RuntimeException) cause;
            }
            return new RuntimeException(cause);
        }
    }

    /**
     * Runnable walkthrough for interviews.
     *
     * <p>Ten callers request the same key simultaneously. The loader is intentionally slow and
     * increments a counter. Expected output demonstrates that loader runs once.
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService loaderPool = Executors.newFixedThreadPool(4);
        ExecutorService callers = Executors.newFixedThreadPool(10);

        try {
            SingleFlightCache<String, String> cache = new SingleFlightCache<>(loaderPool);
            AtomicInteger loaderCallCount = new AtomicInteger(0);
            CountDownLatch startGate = new CountDownLatch(1);
            List<CompletableFuture<String>> results = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
                    await(startGate);
                    return cache.getOrLoad("user:42", key -> {
                        loaderCallCount.incrementAndGet();
                        sleep(300);
                        return "profile-for-" + key;
                    });
                }, callers);
                results.add(result);
            }

            startGate.countDown();

            for (CompletableFuture<String> result : results) {
                System.out.println("Result: " + result.join());
            }

            System.out.println("Loader calls: " + loaderCallCount.get());
            System.out.println("Expected loader calls: 1");
        } finally {
            callers.shutdown();
            loaderPool.shutdown();
            callers.awaitTermination(3, TimeUnit.SECONDS);
            loaderPool.awaitTermination(3, TimeUnit.SECONDS);
        }
    }

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting to start", e);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during simulated load", e);
        }
    }
}

