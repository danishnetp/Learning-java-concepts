package com.learning.concepts.java_features.java14.demo;

/**
 * Provides context for text blocks in Java 14 (second preview).
 */
public class TextBlocksPreviewInfoDemo14 {

    /**
     * Prints a multiline text block and notes its preview status in Java 14.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String xml = """
                <user>
                  <name>Ravi</name>
                  <version>14</version>
                </user>
                """;

        System.out.println("=== Text Blocks (Second Preview in Java 14) ===");
        System.out.println(xml);
    }
}

