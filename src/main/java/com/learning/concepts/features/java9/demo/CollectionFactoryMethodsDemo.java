package com.learning.concepts.features.java9.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Demonstrates Java 9 collection factory methods.
 * <p>
 * {@code List.of}, {@code Set.of}, and {@code Map.of} create compact,
 * immutable collections with less boilerplate than older approaches.
 */
public class CollectionFactoryMethodsDemo {

    /**
     * Creates small immutable collections and prints them.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> names = List.of("Ravi", "Pankaj", "Amit");
        Set<Integer> ids = Set.of(1, 2, 3); // Set.of() does not allow duplicate elements.
        Map<Integer, String> idNameMap = Map.of(1, "Ravi", 2, "Pankaj"); // Map.of() does not allow duplicate keys.

        // names.add("error"); // Cannot add an element because List.of() creates an immutable list.

        System.out.println("=== Collection Factory Methods (Java 9) ===");
        System.out.println("List.of: " + names);
        System.out.println("Set.of: " + ids);
        System.out.println("Map.of: " + idNameMap);
    }
}

