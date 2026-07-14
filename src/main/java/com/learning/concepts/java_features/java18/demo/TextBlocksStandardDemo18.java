package com.learning.concepts.java_features.java18.demo;

/**
 * Demonstrates text blocks as a standard feature in Java 18.
 * Text blocks simplify multi-line string handling.
 */
public class TextBlocksStandardDemo18 {

    /**
     * Creates and displays multi-line strings using text blocks.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String json = """
                {
                    "name": "John Doe",
                    "age": 30,
                    "city": "New York"
                }
                """;

        String html = """
                <html>
                    <head>
                        <title>Demo</title>
                    </head>
                    <body>
                        <h1>Welcome to Java 18</h1>
                    </body>
                </html>
                """;

        String sql = """
                SELECT id, name, email
                FROM users
                WHERE age > 18
                ORDER BY name;
                """;

        System.out.println("=== Text Blocks (Standard in Java 18) ===");
        System.out.println("\n--- JSON ---");
        System.out.println(json);

        System.out.println("--- HTML ---");
        System.out.println(html);

        System.out.println("--- SQL ---");
        System.out.println(sql);

        System.out.println("Text blocks eliminate escape sequences and provide better readability.");
    }
}

