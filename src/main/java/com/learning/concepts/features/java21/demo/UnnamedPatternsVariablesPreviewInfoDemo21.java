package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of unnamed patterns and variables (preview in Java 21).
 */
public class UnnamedPatternsVariablesPreviewInfoDemo21 {

    /**
     * Prints purpose, status, and preview syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Unnamed Patterns and Variables (Preview in Java 21) ===");
        System.out.println("JEP: 443");
        System.out.println("Purpose: Ignore intentionally unused variables with '_'.");
        System.out.println("Requires: --enable-preview on JDK 21.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  if (obj instanceof Point(int x, _)) {");
        System.out.println("      System.out.println(x);");
        System.out.println("  }");
    }
}

