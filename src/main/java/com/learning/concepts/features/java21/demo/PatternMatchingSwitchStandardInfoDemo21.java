package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of pattern matching for switch as a standard feature in Java 21.
 */
public class PatternMatchingSwitchStandardInfoDemo21 {

    /**
     * Prints purpose, status, and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for switch (Standard in Java 21) ===");
        System.out.println("JEP: 441");
        System.out.println("Purpose: Cleaner type-based branching in switch.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  switch (obj) {");
        System.out.println("    case String s -> ...");
        System.out.println("    case Integer i -> ...");
        System.out.println("    default -> ...");
        System.out.println("  }");
    }
}

