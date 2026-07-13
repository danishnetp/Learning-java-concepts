package com.learning.concepts.features.java10.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates {@code Collectors.toUnmodifiableList()},
 * {@code Collectors.toUnmodifiableSet()}, and
 * {@code Collectors.toUnmodifiableMap()} added in Java 10.
 * <p>
 * These collectors are convenient alternatives to wrapping the result of
 * {@code collect(Collectors.toList())} with
 * {@code Collections.unmodifiableList(...)}.
 */
public class CollectorsToUnmodifiableDemo {

    /**
     * Collects stream results into unmodifiable collections and verifies
     * that mutation throws an exception.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> names = Stream.of("Ravi", "Pankaj", "Amit")
                .collect(Collectors.toUnmodifiableList());

        Set<Integer> ids = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableSet());

        Map<Integer, String> idMap = Stream.of(new Integer[]{1, 2})
                .collect(Collectors.toUnmodifiableMap(
                        i -> i,
                        i -> "value-" + i
                ));

        System.out.println("=== Collectors.toUnmodifiable* - Java 10 ===");
        System.out.println("Unmodifiable list: " + names);
        System.out.println("Unmodifiable set:  " + ids);
        System.out.println("Unmodifiable map:  " + idMap);

        // Attempting to mutate throws UnsupportedOperationException
        try {
            names.add("error");
        } catch (UnsupportedOperationException e) {
            System.out.println("names.add() threw UnsupportedOperationException as expected.");
        }
    }
}

