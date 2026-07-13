package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of string templates (preview in Java 21).
 */
public class StringTemplatesPreviewInfoDemo21 {

    /**
     * Prints purpose, status, and preview syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== String Templates (Preview in Java 21) ===");
        System.out.println("JEP: 430");
        System.out.println("Purpose: Safer and cleaner string composition.");
        System.out.println("Requires: --enable-preview on JDK 21.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  String greeting = STR.\"Hello \\{name}\";");
    }
}

