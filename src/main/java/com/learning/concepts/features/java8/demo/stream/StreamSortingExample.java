package com.learning.concepts.features.java8.demo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates sorting a stream in ascending and descending order.
 * <p>
 * The original example uses {@code List.of(...)} and {@code toList()},
 * but this version stays Java 8 compatible by using {@code Arrays.asList(...) }
 * and {@code Collectors.toList()}.
 */
public class StreamSortingExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Pankaj", "Amit");

        List<String> ascending = names.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> descending = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Original:   " + names);
        System.out.println("Ascending:  " + ascending);
        System.out.println("Descending: " + descending);
    }
}

