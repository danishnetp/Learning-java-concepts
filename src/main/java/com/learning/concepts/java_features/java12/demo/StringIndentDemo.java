package com.learning.concepts.java_features.java12.demo;

/**
 * Demonstrates the {@code String.indent(int)} method introduced in Java 12.
 * <p>
 * {@code indent()} adds indentation to every line in a string, useful for
 * code generation, formatted output, and text manipulation.
 */
public class StringIndentDemo {

    /**
     * Shows how indent() adds spaces to each line of a multi-line string.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String text = "Line 1\nLine 2\nLine 3";
        String indented = text.indent(4);
        String negativeIndent = text.indent(-2);

        System.out.println("=== String.indent(int) - Java 12 ===");
        System.out.println("Original:");
        System.out.println(text);
        System.out.println("\nIndented by 4 spaces:");
        System.out.println(indented);
        System.out.println("\nIndented by -2 (removes leading spaces if present):");
        System.out.println(negativeIndent);
    }
}

