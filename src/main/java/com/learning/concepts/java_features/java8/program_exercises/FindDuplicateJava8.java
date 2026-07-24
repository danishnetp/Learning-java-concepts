package com.learning.concepts.java_features.java8.program_exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demonstrates two Java 8 ways to find duplicate values in a list.
 *
 * <p>Input example: ["danish", "samer", "danish", "sreya", "sreya"]</p>
 *
 * <p>Expected duplicates: ["danish", "sreya"]</p>
 */
public class FindDuplicateJava8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("danish", "samer", "danish", "sreya", "sreya");

        System.out.println(findDuplicateUsingIndex(list));
        System.out.println(findDuplicateUsingSet(list));

    }

    /**
     * Finds duplicates using a HashSet.
     *
     * <p>How it works:</p>
     * <ul>
     *     <li>Try adding each element to {@code seen}.</li>
     *     <li>If {@code add()} returns false, the element was already present, so it is a duplicate.</li>
     * </ul>
     *
     * <p>Complexity:</p>
     * <ul>
     *     <li>Time: O(n) average, because HashSet add/contains are O(1) average.</li>
     *     <li>Space: O(n), for the set that tracks seen elements.</li>
     * </ul>
     *
     * <p>Note: This keeps repeated duplicate occurrences, e.g. [a, a, a] -> [a, a].</p>
     */
    static List<String> findDuplicateUsingSet(List<String> list) {
        Set<String> seen = new HashSet<>();
        return list.stream()
                .filter(i -> !seen.add(i))
                .collect(Collectors.toList());
    }

    /**
     * Finds unique duplicate values by comparing first and last occurrence index.
     *
     * <p>Filter condition:</p>
     * <pre>{@code
     * list.indexOf(i) != list.lastIndexOf(i)
     * }</pre>
     *
     * <p>Meaning:</p>
     * <ul>
     *     <li>If first index equals last index, value appears once -> not duplicate.</li>
     *     <li>If first index differs from last index, value appears multiple times -> duplicate.</li>
     * </ul>
     *
     * <p>{@code distinct()} is used so each duplicate value appears once in output.</p>
     *
     * <p>Complexity:</p>
     * <ul>
     *     <li>Time: O(n^2), because indexOf and lastIndexOf are O(n) scans for each element.</li>
     *     <li>Space: O(k), where k is number of unique duplicate values kept by distinct().</li>
     * </ul>
     */
    static List<String> findDuplicateUsingIndex(List<String> list) {
        return list.stream()
                .filter(i -> list.indexOf(i) != list.lastIndexOf(i))
                .distinct()
                .collect(Collectors.toList());
    }
}
