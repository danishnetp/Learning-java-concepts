package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of record patterns as a standard feature in Java 21.
 */
public class RecordPatternsStandardInfoDemo21 {

    /**
     * Prints purpose, status, and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Record Patterns (Standard in Java 21) ===");
        System.out.println("JEP: 440");
        System.out.println("Purpose: Deconstruct record values directly in patterns.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  record Point(int x, int y) {}");
        System.out.println("  if (obj instanceof Point(int x, int y)) {");
        System.out.println("      System.out.println(x + \", \" + y);");
        System.out.println("  }");
    }
}

