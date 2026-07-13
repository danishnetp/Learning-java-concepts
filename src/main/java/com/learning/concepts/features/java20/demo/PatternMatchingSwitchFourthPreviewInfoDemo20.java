package com.learning.concepts.features.java20.demo;

/**
 * Provides an overview of pattern matching for switch (fourth preview in Java 20).
 */
public class PatternMatchingSwitchFourthPreviewInfoDemo20 {

    /**
     * Prints feature purpose and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for switch (Fourth Preview in Java 20) ===");
        System.out.println("Purpose: Cleaner type-based branching in switch.");
        System.out.println("JEP: 433.");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 20.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  switch (obj) {");
        System.out.println("    case String s -> ...");
        System.out.println("    case Integer i -> ...");
        System.out.println("    default -> ...");
        System.out.println("  }");
    }
}

