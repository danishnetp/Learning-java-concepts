package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of unnamed classes and instance main methods (preview in Java 21).
 */
public class UnnamedClassesInstanceMainPreviewInfoDemo21 {

    /**
     * Prints purpose, status, and preview syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Unnamed Classes and Instance Main Methods (Preview in Java 21) ===");
        System.out.println("JEP: 445");
        System.out.println("Purpose: Reduce ceremony for beginner/simple Java programs.");
        System.out.println("Requires: --enable-preview on JDK 21.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  void main() {");
        System.out.println("      System.out.println(\"Hello, Java\");");
        System.out.println("  }");
    }
}

