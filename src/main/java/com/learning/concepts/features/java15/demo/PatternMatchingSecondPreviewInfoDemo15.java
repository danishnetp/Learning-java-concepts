package com.learning.concepts.features.java15.demo;

/**
 * Explains pattern matching for instanceof in second preview state for Java 15.
 */
public class PatternMatchingSecondPreviewInfoDemo15 {

    /**
     * Prints concise examples and rationale for reduced casting boilerplate.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Object value = (System.nanoTime() & 1) == 0 ? "java15" : Integer.valueOf(15);

        System.out.println("=== Pattern Matching for instanceof (Second Preview in Java 15) ===");
        System.out.println("Traditional style:");
        System.out.println("  if (value instanceof String) { String s = (String) value; ... }");
        System.out.println("Preview style:");
        System.out.println("  Use pattern variable directly after instanceof type check.");

        if (value instanceof String s) {
            System.out.println("Runtime sample output: " + s.toUpperCase());
        }
    }
}

