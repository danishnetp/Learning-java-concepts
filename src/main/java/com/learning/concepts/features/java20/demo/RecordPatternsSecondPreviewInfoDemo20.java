package com.learning.concepts.features.java20.demo;

/**
 * Provides an overview of record patterns (second preview in Java 20).
 */
public class RecordPatternsSecondPreviewInfoDemo20 {

    /**
     * Prints feature purpose and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Record Patterns (Second Preview in Java 20) ===");
        System.out.println("Purpose: Deconstruct records in pattern matching expressions.");
        System.out.println("JEP: 432.");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 20.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  record Point(int x, int y) {}");
        System.out.println("  if (obj instanceof Point(int x, int y)) {");
        System.out.println("      System.out.println(x + \", \" + y);");
        System.out.println("  }");
    }
}

