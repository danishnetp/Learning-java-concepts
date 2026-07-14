package com.learning.concepts.java_features.java16.demo;

/**
 * Describes strong encapsulation of JDK internals in Java 16 (JEP 396).
 */
public class StrongEncapsulationInfoDemo16 {

    /**
     * Prints migration-oriented notes for strong encapsulation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Strong Encapsulation of JDK Internals (Java 16) ===");
        System.out.println("Illegal reflective access to JDK internals is strongly restricted by default.");
        System.out.println("Prefer supported public APIs over sun.* and other internal packages.");
    }
}

