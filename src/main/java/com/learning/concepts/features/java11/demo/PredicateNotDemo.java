package com.learning.concepts.features.java11.demo;

import java.util.List;
import java.util.function.Predicate;

/**
 * Demonstrates the {@code Predicate.not()} static method introduced in Java 11.
 * <p>
 * {@code Predicate.not()} provides a convenient way to negate a predicate,
 * improving readability in stream operations and other contexts where
 * predicate negation is needed.
 */
public class PredicateNotDemo {

    /**
     * Filters a list of strings, demonstrating the use of {@code Predicate.not()}
     * to exclude empty strings.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> items = List.of("", "Java", "", "11", "");

        System.out.println("=== Predicate.not() - Java 11 ===");
        System.out.println("Original list: " + items);

        // Traditional approach with negation
        var filteredTraditional = items.stream()
                .filter(s -> !s.isEmpty())
                .toList();

        // Java 11 Predicate.not()
        var filteredWithNot = items.stream()
                .filter(Predicate.not(String::isEmpty))
                .toList();

        System.out.println("Filtered (traditional): " + filteredTraditional);
        System.out.println("Filtered (Predicate.not()): " + filteredWithNot);
    }
}

