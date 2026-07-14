package com.learning.concepts.java_features.java15.demo;

/**
 * Explains sealed classes as a preview feature in Java 15.
 */
public class SealedClassesPreviewInfoDemo15 {

    /**
     * Prints sealed class concept and syntax sample.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes (Preview in Java 15) ===");
        System.out.println("Purpose: restrict inheritance hierarchy explicitly.");
        System.out.println("Sample syntax:");
        System.out.println("  public sealed class Shape permits Circle, Rectangle {}" );
        System.out.println("Permitted subclasses must declare final/sealed/non-sealed.");
    }
}

