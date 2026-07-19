package com.learning.concepts.java_features.java8.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates sorting a {@link Map} by key and by value using Java 8 streams.
 * <p>
 * This example uses:
 * <ul>
 *   <li>{@link Map.Entry#comparingByKey()} for key-based sorting</li>
 *   <li>{@link Map.Entry#comparingByValue()} for value-based sorting</li>
 * </ul>
 * The sorted results are collected into {@link LinkedHashMap} so insertion
 * order is preserved for display.
 */
public class MapSortingExample {

    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Ravi", 85);
        scores.put("Pankaj", 92);
        scores.put("Amit", 78);
        scores.put("Suresh", 88);

        Map<String, Integer> sortedByKeyAscending = scores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        Map<String, Integer> sortedByKeyDescending = scores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        Map<String, Integer> sortedByValueAscending = scores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        Map<String, Integer> sortedByValueDescending = scores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Original map: " + scores);
        System.out.println("Sorted by key ascending: " + sortedByKeyAscending);
        System.out.println("Sorted by key descending: " + sortedByKeyDescending);
        System.out.println("Sorted by value ascending: " + sortedByValueAscending);
        System.out.println("Sorted by value descending: " + sortedByValueDescending);
    }
}

