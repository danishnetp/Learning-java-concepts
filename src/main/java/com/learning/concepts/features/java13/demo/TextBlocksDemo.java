package com.learning.concepts.features.java13.demo;

/**
 * Demonstrates text blocks, introduced as a preview feature in Java 13.
 * <p>
 * Text blocks became standard in later Java versions, so this project can
 * compile and run the same syntax while still documenting Java 13 history.
 */
public class TextBlocksDemo {

    /**
     * Prints a multi-line JSON and SQL example written as text blocks.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String json = """
                {
                  "name": "Ravi",
                  "feature": "Text Blocks",
                  "jdk": 13
                }
                """;

        String sql = """
                SELECT id, name
                FROM users
                WHERE active = true
                ORDER BY name
                """;

        System.out.println("=== Text Blocks (Preview in Java 13) ===");
        System.out.println("JSON text block:\n" + json);
        System.out.println("SQL text block:\n" + sql);
    }
}

