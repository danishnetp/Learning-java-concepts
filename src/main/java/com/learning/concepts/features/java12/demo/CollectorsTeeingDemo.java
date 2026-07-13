package com.learning.concepts.features.java12.demo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the {@code Collectors.teeing()} collector introduced in Java 12.
 * <p>
 * {@code teeing()} allows a stream to be processed by two different collectors
 * simultaneously, with results combined by a function.
 */
public class CollectorsTeeingDemo {

    /**
     * Uses teeing to calculate sum and count simultaneously, then formats the result.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Using teeing to get sum and count at the same time
        var result = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.counting(),
                        (sum, count) -> "Sum: " + sum + ", Count: " + count + ", Average: " + (sum / (double) count)
                ));

        // Another example: min and max
        var minMax = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> "Min: " + min.orElse(0) + ", Max: " + max.orElse(0)
                ));

        System.out.println("=== Collectors.teeing() - Java 12 ===");
        System.out.println("Numbers: " + numbers);
        System.out.println("Statistics: " + result);
        System.out.println("Range: " + minMax);
    }
}

