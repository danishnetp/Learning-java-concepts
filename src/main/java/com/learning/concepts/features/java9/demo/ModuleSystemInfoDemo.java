package com.learning.concepts.features.java9.demo;

/**
 * Demonstrates the Java Platform Module System (JPMS), the flagship feature
 * introduced in Java 9.
 * <p>
 * This sample does not create a real named module for the project; instead it
 * inspects the module information of the current class at runtime and prints a
 * simple example of what a {@code module-info.java} declaration looks like.
 */
public class ModuleSystemInfoDemo {

    /**
     * Prints basic runtime module metadata and a sample module descriptor.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Module module = ModuleSystemInfoDemo.class.getModule();

        System.out.println("=== Java 9 Module System (JPMS) ===");
        System.out.println("Current module name: " + module.getName());
        System.out.println("Is named module: " + module.isNamed());
        System.out.println("Sample module-info.java:");
        System.out.println("module com.example.app {");
        System.out.println("    requires java.sql;");
        System.out.println("    exports com.example.api;");
        System.out.println("}");
    }
}

