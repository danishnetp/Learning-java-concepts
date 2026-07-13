package com.learning.concepts.features.java19.demo;

/**
 * Provides an overview of scoped values (incubator in Java 19).
 */
public class ScopedValuesIncubatorInfoDemo19 {

    /**
     * Prints scoped values purpose and guidance.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Scoped Values (Incubator in Java 19) ===");
        System.out.println("Purpose: Share immutable context safely within a call tree.");
        System.out.println("Status: Incubator in Java 19 (JEP 429).");
        System.out.println();
        System.out.println("Why it matters:");
        System.out.println("  - Safer than mutable shared context");
        System.out.println("  - Cleaner alternative for some ThreadLocal scenarios");
        System.out.println("  - Better fit for structured concurrency style code");
    }
}

