package com.learning.concepts.features.java16.demo;

/**
 * Demonstrates pattern matching for instanceof as a standard feature in Java 16.
 */
public class PatternMatchingInstanceofStandardDemo16 {

    /**
     * Shows concise type check and use of pattern variable.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Object value = Math.random() > 0.5 ? "java16" : Integer.valueOf(16);

        System.out.println("=== Pattern Matching for instanceof (Standard in Java 16) ===");

        if (value instanceof String s) {
            System.out.println("String branch: " + s.toUpperCase());
            System.out.println("Length: " + s.length());
        } else {
            System.out.println("Non-string branch: " + value + " (" + value.getClass().getSimpleName() + ")");
        }
    }
}

