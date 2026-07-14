package com.learning.concepts.java_features.java9.demo;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Demonstrates Stream API enhancements introduced in Java 9.
 * <p>
 * This example covers:
 * <ul>
 *   <li>{@code takeWhile}</li>
 *   <li>{@code dropWhile}</li>
 *   <li>{@code Stream.ofNullable}</li>
 *   <li>the predicate-based {@code Stream.iterate} overload</li>
 * </ul>
 */
public class StreamEnhancementsDemo {

    /**
     * Runs a few examples that show how Java 9 made stream creation and
     * processing more expressive.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 0, 5);

        System.out.println("=== Stream Enhancements (Java 9) ===");
        System.out.println("takeWhile < 4: " + numbers.stream()
                .takeWhile(n -> n < 4)
                .collect(Collectors.toList()));

        System.out.println("dropWhile < 4: " + numbers.stream()
                .dropWhile(n -> n < 4)
                .collect(Collectors.toList()));

        System.out.println("ofNullable(null): " + Stream.ofNullable(null).count());

        System.out.println("iterate with predicate: " +
                Stream.iterate(1, n -> n <= 5, n -> n + 1)
                        .collect(Collectors.toList()));
    }
}

