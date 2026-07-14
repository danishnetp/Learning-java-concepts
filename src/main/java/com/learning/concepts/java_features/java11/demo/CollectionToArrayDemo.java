package com.learning.concepts.java_features.java11.demo;

import java.util.List;

/**
 * Demonstrates the {@code Collection.toArray(IntFunction)} method introduced
 * in Java 11.
 * <p>
 * This method simplifies the conversion of a collection to a typed array by
 * accepting a constructor reference (e.g., {@code String[]::new}) instead of
 * requiring an empty array to be passed.
 */
public class CollectionToArrayDemo {

    /**
     * Shows how to convert a list to a typed array using the convenience
     * method and comparing with the traditional approach.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> names = List.of("Ravi", "Pankaj", "Amit");

        System.out.println("=== Collection.toArray(IntFunction) - Java 11 ===");

        // Java 11 way
        String[] array = names.toArray(String[]::new);
        System.out.println("Array from toArray(String[]::new):");
        for (String name : array) {
            System.out.println("  " + name);
        }

        // Traditional way (still works)
        String[] traditional = names.toArray(new String[0]);
        System.out.println("Traditional way toArray(new String[0]) still works:");
        for (String name : traditional) {
            System.out.println("  " + name);
        }
    }
}

