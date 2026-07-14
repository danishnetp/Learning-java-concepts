package com.learning.concepts.java_features.java17.demo;

/**
 * Summarizes context-specific deserialization filters (JEP 415) in Java 17.
 */
public class DeserializationFilterInfoDemo17 {

    /**
     * Prints security-focused notes on deserialization filter factories.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Context-Specific Deserialization Filters (Java 17) ===");
        System.out.println("JEP 415 introduces filter factory support for composed deserialization policies.");
        System.out.println("Helps mitigate unsafe deserialization attack vectors.");
    }
}

