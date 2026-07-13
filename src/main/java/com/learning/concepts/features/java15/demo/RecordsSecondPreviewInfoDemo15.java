package com.learning.concepts.features.java15.demo;

/**
 * Explains records as second preview in Java 15.
 */
public class RecordsSecondPreviewInfoDemo15 {

    /**
     * Prints record syntax and generated member summary.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Records (Second Preview in Java 15) ===");
        System.out.println("Record syntax sample:");
        System.out.println("  record User(String name, int age) {}" );
        System.out.println("Generated members include constructor, accessors, equals/hashCode/toString.");
    }
}

