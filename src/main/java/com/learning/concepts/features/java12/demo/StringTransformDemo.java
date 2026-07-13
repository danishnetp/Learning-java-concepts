package com.learning.concepts.features.java12.demo;

/**
 * Demonstrates the {@code String.transform(Function)} method introduced in Java 12.
 * <p>
 * {@code transform()} applies a function to the entire string and returns the result,
 * providing a terminal operation for string transformations.
 */
public class StringTransformDemo {

    /**
     * Shows various transformations using the transform() method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String text = "hello";

        // Simple transformation
        String uppercase = text.transform(String::toUpperCase);

        // Chained transformation
        String reversed = text.transform(s -> new StringBuilder(s).reverse().toString());

        // Complex transformation
        String withPrefix = text.transform(s -> "Result: " + s.toUpperCase() + "!");

        // Using length
        int len = text.transform(String::length);

        System.out.println("=== String.transform(Function) - Java 12 ===");
        System.out.println("Original: '" + text + "'");
        System.out.println("Uppercase: '" + uppercase + "'");
        System.out.println("Reversed: '" + reversed + "'");
        System.out.println("With prefix: '" + withPrefix + "'");
        System.out.println("Length: " + len);
    }
}

