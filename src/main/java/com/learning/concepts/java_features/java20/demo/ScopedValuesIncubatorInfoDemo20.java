package com.learning.concepts.java_features.java20.demo;

/**
 * Provides an overview of scoped values (incubator in Java 20).
 */
public class ScopedValuesIncubatorInfoDemo20 {

    /**
     * Prints feature purpose and status.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Scoped Values (Incubator in Java 20) ===");
        System.out.println("Purpose: Share immutable context safely in a call scope.");
        System.out.println("JEP: 429.");
        System.out.println();
        System.out.println("Why use it:");
        System.out.println("  - Safer context propagation");
        System.out.println("  - Clearer ownership and lifetime");
        System.out.println("  - Alternative to some ThreadLocal usage patterns");
    }
}

