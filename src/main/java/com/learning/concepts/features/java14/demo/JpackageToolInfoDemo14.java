package com.learning.concepts.features.java14.demo;

/**
 * Provides an overview of the jpackage tool in Java 14.
 */
public class JpackageToolInfoDemo14 {

    /**
     * Prints sample jpackage commands for native packaging.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== jpackage Tool (Java 14 Incubator Context) ===");
        System.out.println("Example native package command:");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type msi");
        System.out.println("App image command:");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type app-image");
    }
}

