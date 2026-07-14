package com.learning.concepts.java_features.java18.demo;

/**
 * Demonstrates pattern matching for switch (second preview in Java 18).
 */
public class PatternMatchingSwitchPreviewDemo18 {

    private static String describeObject(Object obj) {
        // Compile-safe fallback so this project builds without --enable-preview.
        if (obj == null) {
            return "Null value";
        }
        if (obj instanceof String) {
            return "String: " + obj;
        }
        if (obj instanceof Integer) {
            return "Integer: " + obj;
        }
        if (obj instanceof Double) {
            return "Double: " + obj;
        }
        if (obj instanceof Boolean) {
            return "Boolean: " + obj;
        }
        return "Unknown type";
    }

    /**
     * Uses switch with type patterns to handle different object types.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Object[] objects = { "Hello", 42, 3.14, true, null };

        System.out.println("=== Pattern Matching for switch (Preview in Java 18) ===");
        System.out.println("Preview syntax requires --enable-preview.");
        System.out.println("This demo uses compile-safe fallback output:");
        for (Object obj : objects) {
            String result = describeObject(obj);
            System.out.println(result);
        }

        System.out.println();
        System.out.println("Preview example:");
        System.out.println("  switch (obj) {");
        System.out.println("    case String s -> ...");
        System.out.println("    case Integer i -> ...");
        System.out.println("    default -> ...");
        System.out.println("  }");
    }
}

