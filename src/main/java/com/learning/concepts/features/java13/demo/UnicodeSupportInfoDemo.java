package com.learning.concepts.features.java13.demo;

/**
 * Highlights Unicode 12.1 support updates in Java 13.
 * <p>
 * Unicode data updates improve handling of newer characters, categories,
 * and normalization behavior in text processing APIs.
 */
public class UnicodeSupportInfoDemo {

    /**
     * Prints basic character metadata to illustrate Unicode-aware APIs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String sample = "\u263A"; // white smiling face
        int codePoint = sample.codePointAt(0);

        System.out.println("=== Unicode Support (Java 13 / Unicode 12.1) ===");
        System.out.println("Sample character: " + sample);
        System.out.println("Code point: U+" + Integer.toHexString(codePoint).toUpperCase());
        System.out.println("Character type: " + Character.getType(codePoint));
    }
}

