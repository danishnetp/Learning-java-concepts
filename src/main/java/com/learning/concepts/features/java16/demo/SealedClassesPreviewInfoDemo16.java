package com.learning.concepts.features.java16.demo;

/**
 * Provides an overview of sealed classes in second preview status for Java 16.
 */
public class SealedClassesPreviewInfoDemo16 {

    /**
     * Prints sealed class intent and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes (Second Preview in Java 16) ===");
        System.out.println("Purpose: control inheritance with permits list.");
        System.out.println("Sample:");
        System.out.println("  public sealed class Shape permits Circle, Rectangle {}" );
        System.out.println("Subclasses must be final, sealed, or non-sealed.");
    }
}

