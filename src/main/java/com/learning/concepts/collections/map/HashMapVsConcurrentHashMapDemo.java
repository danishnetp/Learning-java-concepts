package com.learning.concepts.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapVsConcurrentHashMapDemo {

    public static void main(String[] args) throws InterruptedException {
        runHashMapExample();
        runConcurrentHashMapExample();
    }

    private static void runHashMapExample() {
        System.out.println("=== HashMap (single-thread friendly) ===");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        hashMap.putIfAbsent("Two", 22); // Existing key, value remains unchanged.
        hashMap.putIfAbsent("Four", 4);

        // HashMap allows one null key and multiple null values.
        hashMap.put(null, 0);
        hashMap.put("Optional", null);

        System.out.println("HashMap entries: " + hashMap);
    }

    private static void runConcurrentHashMapExample() throws InterruptedException {
        System.out.println("\n=== ConcurrentHashMap (thread-safe updates) ===");

        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("counter", 0);

        int threadCount = 4;
        int incrementsPerThread = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    concurrentMap.compute("counter", (key, value) -> value + 1);
                }
            });
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }

        int expected = threadCount * incrementsPerThread;
        int actual = concurrentMap.get("counter");

        System.out.println("Expected counter: " + expected);
        System.out.println("Actual counter  : " + actual);

        try {
            concurrentMap.put(null, 1);
        } catch (NullPointerException ex) {
            System.out.println("ConcurrentHashMap null key: not allowed (NullPointerException)");
        }
    }
}

