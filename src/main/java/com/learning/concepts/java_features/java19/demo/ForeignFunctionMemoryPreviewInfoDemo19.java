package com.learning.concepts.java_features.java19.demo;

/**
 * Provides an overview of the Foreign Function & Memory API (preview in Java 19).
 */
public class ForeignFunctionMemoryPreviewInfoDemo19 {

    /**
     * Prints feature purpose and Java 19 status.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Foreign Function & Memory API (Preview in Java 19) ===");
        System.out.println("Purpose: Safer native interop and memory access without JNI-heavy code.");
        System.out.println("Status: Re-preview in Java 19 (JEP 424).");
        System.out.println();
        System.out.println("Highlights:");
        System.out.println("  - Access native functions from Java");
        System.out.println("  - Work with off-heap memory more safely");
        System.out.println("  - Ongoing API refinement toward stability");
    }
}

