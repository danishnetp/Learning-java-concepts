package com.learning.concepts.java_features.java13.demo;

/**
 * Summarizes Dynamic CDS Archives introduced in Java 13.
 * <p>
 * Dynamic CDS allows generating a class data sharing archive at application
 * exit, which can then be reused to improve startup and memory sharing.
 */
public class DynamicCdsInfoDemo {

    /**
     * Prints usage commands and purpose of dynamic CDS.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Dynamic CDS Archives (Java 13) ===");
        System.out.println("Step 1: Create archive at exit");
        System.out.println("  java -XX:ArchiveClassesAtExit=app.jsa -cp app.jar com.example.Main");
        System.out.println("Step 2: Reuse archive on next startup");
        System.out.println("  java -XX:SharedArchiveFile=app.jsa -cp app.jar com.example.Main");
        System.out.println("Benefit: faster startup and lower memory for repeated runs.");
    }
}

