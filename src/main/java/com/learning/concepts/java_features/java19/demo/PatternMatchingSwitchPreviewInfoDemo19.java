package com.learning.concepts.java_features.java19.demo;

/**
 * Provides an overview of pattern matching for switch (third preview in Java 19).
 */
public class PatternMatchingSwitchPreviewInfoDemo19 {

    /**
     * Prints feature intent and preview syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for switch (Third Preview in Java 19) ===");
        System.out.println("Purpose: Cleaner type-based branching in switch.");
        System.out.println("Status: Preview feature in Java 19.");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 19.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  switch (obj) {");
        System.out.println("    case String s -> ...");
        System.out.println("    case Integer i -> ...");
        System.out.println("    default -> ...");
        System.out.println("  }");
    }
}

