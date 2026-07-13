package com.learning.concepts.features.java17.demo;

/**
 * Provides an overview of pattern matching for switch as preview in Java 17.
 */
public class PatternMatchingSwitchPreviewInfoDemo17 {

    /**
     * Prints pattern-matching switch concepts and preview syntax notes.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for switch (Preview in Java 17) ===");
        System.out.println("Concept: switch can match by type patterns, not just constants.");
        System.out.println("Preview syntax example:");
        System.out.println("  switch (obj) {");
        System.out.println("      case Integer i -> \"int: \" + i;");
        System.out.println("      case String s -> \"string: \" + s;");
        System.out.println("      default -> \"other\";");
        System.out.println("  }");
        System.out.println("Requires preview flags in Java 17 builds.");
    }
}

