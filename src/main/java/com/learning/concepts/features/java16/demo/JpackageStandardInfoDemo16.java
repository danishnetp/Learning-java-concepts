package com.learning.concepts.features.java16.demo;

/**
 * Highlights jpackage as a standard tool in Java 16.
 */
public class JpackageStandardInfoDemo16 {

    /**
     * Prints common jpackage command examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== jpackage (Standard Tool in Java 16) ===");
        System.out.println("Windows installer example:");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type msi");
        System.out.println("App image example:");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type app-image");
    }
}

