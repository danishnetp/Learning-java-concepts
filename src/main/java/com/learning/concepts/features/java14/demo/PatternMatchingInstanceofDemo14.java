package com.learning.concepts.features.java14.demo;

/**
 * Demonstrates pattern matching for {@code instanceof}, introduced as preview
 * in Java 14.
 * <p>
 * The syntax was finalized in later JDK versions. This sample shows a
 * Java-14-compatible style while explaining the preview feature.
 */
public class PatternMatchingInstanceofDemo14 {

    /**
     * Compares traditional instanceof+cast style with concise preview syntax
     * (shown as explanatory output).
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Object value = "java14";

        System.out.println("=== Pattern Matching for instanceof (Preview in Java 14) ===");

        if (value instanceof String) {
            String s = (String) value;
            System.out.println("Traditional style result: " + s.toUpperCase());
        }

        System.out.println("Preview syntax example:");
        System.out.println("  if (value instanceof String s) { ... }");
    }
}

