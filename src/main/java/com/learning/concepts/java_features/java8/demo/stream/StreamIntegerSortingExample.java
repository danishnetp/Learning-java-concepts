package com.learning.concepts.java_features.java8.demo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates sorting a stream of integers using a comparator.
 * <p>
 * This example shows both ascending and descending order with a
 * {@link Comparator}, which is a common Java 8 stream sorting pattern.
 */
public class StreamIntegerSortingExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 12, 89, 3, 27, 12);

        List<Integer> ascending = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Original:   " + numbers);
        System.out.println("Ascending:  " + ascending);
        System.out.println("Descending: " + descending);
    }
}

