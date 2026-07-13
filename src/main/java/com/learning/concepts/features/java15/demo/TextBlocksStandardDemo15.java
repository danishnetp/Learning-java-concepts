package com.learning.concepts.features.java15.demo;

/**
 * Demonstrates text blocks as a standard feature in Java 15.
 */
public class TextBlocksStandardDemo15 {

    /**
     * Prints JSON and SQL examples using text blocks.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String json = """
                {
                  "name": "Ravi",
                  "jdk": 15,
                  "feature": "Text Blocks"
                }
                """;

        String sql = """
                SELECT id, name
                FROM users
                WHERE active = true
                ORDER BY name
                """;

        System.out.println("=== Text Blocks (Standard in Java 15) ===");
        System.out.println("JSON:\n" + json);
        System.out.println("SQL:\n" + sql);
    }
}

