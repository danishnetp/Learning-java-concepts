package com.learning.concepts.java_features.java17.demo;

/**
 * Summarizes always-strict floating-point semantics restoration (JEP 306).
 */
public class StrictFloatingPointInfoDemo17 {

    /**
     * Prints strict floating-point behavior notes and a tiny calculation sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        double value = 0.1d + 0.2d;

        System.out.println("=== Always-Strict Floating-Point Semantics (Java 17) ===");
        System.out.println("Computation sample: 0.1 + 0.2 = " + value);
        System.out.println("Java 17 restores always-strict IEEE 754 semantics by default.");
    }
}

