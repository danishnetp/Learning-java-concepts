package com.learning.concepts.java_features.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Demonstrates the Stream reduce(BinaryOperator) terminal operation.
 * <p>
 * The reduce operation combines all elements in a stream into a single result.
 * This example shows two common uses:
 * <ul>
 *   <li>Summing integers</li>
 *   <li>Finding the longest string by using a comparator</li>
 * </ul>
 */
public class StreamReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        List<String> names = Arrays.asList("Ravi", "Pankaj", "Amit", "Suresh");

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        Optional<String> longestName = names.stream()
                .reduce((left, right) -> left.length() >= right.length() ? left : right);

        Optional<Integer> maxNumber = numbers.stream()
                .reduce(Integer::max);

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum using reduce(BinaryOperator): " + sum);
        System.out.println("Names: " + names);
        System.out.println("Longest name using reduce(BinaryOperator): " + longestName.orElse("N/A"));
        System.out.println("Max number using reduce(BinaryOperator): " + maxNumber.orElse(-1));

        List<Integer> sortedDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Descending order example: " + sortedDescending);
    }
}

