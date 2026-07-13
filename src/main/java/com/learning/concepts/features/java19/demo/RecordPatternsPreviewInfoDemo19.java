package com.learning.concepts.features.java19.demo;

/**
 * Provides an overview of record patterns (preview in Java 19).
 */
public class RecordPatternsPreviewInfoDemo19 {

    /**
     * Prints feature intent and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Record Patterns (Preview in Java 19) ===");
        System.out.println("Purpose: Deconstruct record components directly in pattern matching.");
        System.out.println("Status: First preview in Java 19 (JEP 405).");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 19.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  record Point(int x, int y) {}");
        System.out.println("  if (obj instanceof Point(int x, int y)) {");
        System.out.println("      System.out.println(x + \", \" + y);");
        System.out.println("  }");
    }
}

