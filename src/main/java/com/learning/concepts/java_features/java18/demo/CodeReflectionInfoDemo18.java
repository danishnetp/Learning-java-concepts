package com.learning.concepts.java_features.java18.demo;

/**
 * Provides an overview of the Code Reflection API (incubator in Java 18).
 */
public class CodeReflectionInfoDemo18 {

    /**
     * Prints information about the Code Reflection API.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Code Reflection API (Incubator in Java 18) ===");
        System.out.println("Purpose: Compile-time accessible reflection for code.");
        System.out.println();

        System.out.println("Key features:");
        System.out.println("  - Reflect over program structure at compile time");
        System.out.println("  - Tree-like representation of code");
        System.out.println("  - Foundation for advanced code analysis tools");
        System.out.println("  - Enables compile-time code generation");
        System.out.println();

        System.out.println("Use cases:");
        System.out.println("  - Code generation frameworks");
        System.out.println("  - Static analysis tools");
        System.out.println("  - Documentation generators");
        System.out.println("  - IDE features and tooling");
        System.out.println();

        System.out.println("API package: java.lang.reflect (future expansion)");
        System.out.println("Status: First incubating API in Java 18.");
    }
}

