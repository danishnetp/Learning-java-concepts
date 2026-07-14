package com.learning.concepts.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demonstrates practical usage patterns for Map.computeIfAbsent().
 *
 * computeIfAbsent(key, mappingFunction):
 * - returns the existing value when key is already mapped to a non-null value
 * - otherwise computes a new value via mappingFunction and stores it in the map
 * - if mappingFunction returns null, no mapping is recorded
 *
 * This file includes common interview scenarios: grouping, counters,
 * lazy initialization, null-return behavior, and ConcurrentHashMap usage.
 */
public class ComputeIfAbsentDemo {

    public static void main(String[] args) {
        groupUsersByRole();
        buildFrequencyMap();
        lazyObjectInitialization();
        nullReturnBehavior();
        concurrentMapAtomicUsage();
    }

    /**
     * Common interview pattern:
     * groupUsersByRole map where each role points to a list of users.
     */
    private static void groupUsersByRole() {
        System.out.println("=== 1) Grouping Example ===");

        Map<String, List<String>> groups = new HashMap<>();

        // Explanation of this statement:
        // groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Alice");
        // 1) Check key "admin".
        // 2) If absent, create/store new ArrayList.
        // 3) Return mapped list and add "Alice".
        // Equivalent verbose code:
        // List<String> users = groups.get("admin");
        // if (users == null) {
        //     users = new ArrayList<>();
        //     groups.put("admin", users);
        // }
        // users.add("Alice");
        groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Alice");
        groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Bob");
        groups.computeIfAbsent("user", k -> new ArrayList<>()).add("Charlie");

        System.out.println(groups);
        System.out.println();
    }

    private static void buildFrequencyMap() {
        System.out.println("=== 2) Frequency Counter Example ===");

        String[] words = {"java", "map", "java", "hashmap", "map", "java"};
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            // Initialize missing key with 0, then increment.
            frequency.put(word, frequency.computeIfAbsent(word, k -> 0) + 1);
        }

        System.out.println(frequency);
        System.out.println();
    }

    private static void lazyObjectInitialization() {
        System.out.println("=== 3) Lazy Initialization Example ===");

        Map<String, ExpensiveObject> cache = new HashMap<>();

        ExpensiveObject first = cache.computeIfAbsent("db-connection", k -> new ExpensiveObject("created-once"));
        ExpensiveObject second = cache.computeIfAbsent("db-connection", k -> new ExpensiveObject("should-not-create"));

        System.out.println("First  : " + first);
        System.out.println("Second : " + second);
        System.out.println("Same reference? " + (first == second));
        System.out.println();
    }

    private static void nullReturnBehavior() {
        System.out.println("=== 4) Mapping Function Returns null ===");

        Map<String, String> map = new HashMap<>();

        String value = map.computeIfAbsent("missing", k -> null);

        System.out.println("Returned value       : " + value);
        System.out.println("Contains key 'missing'? " + map.containsKey("missing"));
        System.out.println();
    }

    private static void concurrentMapAtomicUsage() {
        System.out.println("=== 5) ConcurrentHashMap Atomic per Key ===");

        ConcurrentHashMap<String, List<String>> sessionsByUser = new ConcurrentHashMap<>();

        sessionsByUser.computeIfAbsent("u1", k -> new ArrayList<>()).add("session-1");
        sessionsByUser.computeIfAbsent("u1", k -> new ArrayList<>()).add("session-2");

        System.out.println(sessionsByUser);
        System.out.println();
    }

    private static final class ExpensiveObject {
        private final String value;

        private ExpensiveObject(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ExpensiveObject{" + "value='" + value + "'" + '}';
        }
    }
}

