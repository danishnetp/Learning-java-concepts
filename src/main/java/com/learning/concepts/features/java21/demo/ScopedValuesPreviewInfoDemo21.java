package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of scoped values (preview in Java 21).
 */
public class ScopedValuesPreviewInfoDemo21 {

    /**
     * Prints purpose, status, and preview syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Scoped Values (Preview in Java 21) ===");
        System.out.println("JEP: 446");
        System.out.println("Purpose: Safer immutable context sharing for call chains.");
        System.out.println("Requires: --enable-preview on JDK 21.");
        System.out.println();
        System.out.println("Example use case: request-scoped context in concurrent services.");
    }
}

