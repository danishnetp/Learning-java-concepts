package com.learning.concepts.java_features.java9.demo;

import java.util.Optional;

/**
 * Demonstrates Optional API enhancements added in Java 9.
 * <p>
 * This sample shows {@code ifPresentOrElse}, {@code or}, and
 * {@code Optional.stream()}.
 */
public class OptionalEnhancementsDemo {

    /**
     * Prints outputs from the new Optional convenience methods.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        Optional<String> value = Optional.of("Java9");

        System.out.println("=== Optional Enhancements (Java 9) ===");

        value.ifPresentOrElse(
                v -> System.out.println("ifPresentOrElse value: " + v),
                () -> System.out.println("ifPresentOrElse empty")
        );

        String resolved = empty.or(() -> Optional.of("fallback")).get();
        System.out.println("or() fallback: " + resolved);

        long streamCount = value.stream().count();
        System.out.println("stream() count: " + streamCount);
    }
}

