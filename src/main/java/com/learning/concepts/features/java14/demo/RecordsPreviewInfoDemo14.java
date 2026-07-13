package com.learning.concepts.features.java14.demo;

/**
 * Explains records as a preview feature in Java 14.
 * <p>
 * Records were preview in Java 14 and finalized later. This class prints a
 * conceptual example while staying broadly compatible.
 */
public class RecordsPreviewInfoDemo14 {

    /**
     * Prints record feature summary and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Records (Preview in Java 14) ===");
        System.out.println("Record syntax sample:");
        System.out.println("  record User(String name, int age) {}" );
        System.out.println("Records auto-generate constructor/accessors/equals/hashCode/toString.");
    }
}

