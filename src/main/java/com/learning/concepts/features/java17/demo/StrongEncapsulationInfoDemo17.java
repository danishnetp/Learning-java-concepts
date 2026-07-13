package com.learning.concepts.features.java17.demo;

/**
 * Describes strong encapsulation of JDK internals in Java 17 (JEP 403).
 */
public class StrongEncapsulationInfoDemo17 {

    /**
     * Prints migration-focused notes for avoiding internal JDK APIs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Strong Encapsulation of JDK Internals (Java 17) ===");
        System.out.println("Illegal deep reflection into JDK internals is strongly restricted by default.");
        System.out.println("Migrate from internal packages (for example sun.*) to supported APIs.");
    }
}

