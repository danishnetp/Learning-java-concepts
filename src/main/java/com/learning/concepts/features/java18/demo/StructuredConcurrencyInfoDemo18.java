package com.learning.concepts.features.java18.demo;

/**
 * Provides an overview of structured concurrency (incubator in Java 18).
 */
public class StructuredConcurrencyInfoDemo18 {

    /**
     * Prints information about structured concurrency API.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Structured Concurrency (Incubator in Java 18) ===");
        System.out.println("Purpose: Improve reliability of concurrent code.");
        System.out.println("Part of Project Loom.");
        System.out.println();
        System.out.println("Key benefits:");
        System.out.println("  - Structured task hierarchies");
        System.out.println("  - Automatic cancellation propagation");
        System.out.println("  - Better error handling");
        System.out.println("  - Resource cleanup guarantees");
        System.out.println();
        System.out.println("Status: Incubating API, subject to change.");
    }
}

