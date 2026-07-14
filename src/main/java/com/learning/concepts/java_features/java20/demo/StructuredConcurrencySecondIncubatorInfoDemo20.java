package com.learning.concepts.java_features.java20.demo;

/**
 * Provides an overview of structured concurrency (second incubator in Java 20).
 */
public class StructuredConcurrencySecondIncubatorInfoDemo20 {

    /**
     * Prints feature purpose and status.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Structured Concurrency (Second Incubator in Java 20) ===");
        System.out.println("Purpose: Treat related concurrent tasks as one unit of work.");
        System.out.println("JEP: 437.");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("  - Better cancellation propagation");
        System.out.println("  - Clear task lifecycles");
        System.out.println("  - Simplified error handling");
    }
}

