package com.learning.concepts.java_features.java10.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Demonstrates unmodifiable collection copy factory methods added in Java 10.
 * <p>
 * {@code List.copyOf}, {@code Set.copyOf}, and {@code Map.copyOf} produce
 * unmodifiable snapshots of existing collections. Changes to the original
 * after copying are not visible in the copy.
 */
public class UnmodifiableCollectionCopyDemo {

    /**
     * Creates mutable collections, copies them with the Java 10 factory
     * methods, and demonstrates that mutations on the original do not affect
     * the copy.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        var originalList = new ArrayList<>(List.of("Ravi", "Pankaj", "Amit"));
        var copyList = List.copyOf(originalList);

        var originalSet = new HashSet<>(Set.of("A", "B", "C"));
        var copySet = Set.copyOf(originalSet);

        var originalMap = new HashMap<>(Map.of(1, "one", 2, "two"));
        var copyMap = Map.copyOf(originalMap);

        // Mutate the originals after copying
        originalList.add("Suresh");
        originalSet.add("D");
        originalMap.put(3, "three");

        System.out.println("=== Unmodifiable Collection Copies - Java 10 ===");
        System.out.println("Original list: " + originalList);
        System.out.println("Copied list (unmodified): " + copyList);
        System.out.println("Original set: " + originalSet);
        System.out.println("Copied set (unmodified): " + copySet);
        System.out.println("Original map: " + originalMap);
        System.out.println("Copied map (unmodified): " + copyMap);

        // Attempting to add to a copy throws UnsupportedOperationException
        try {
            copyList.add("error");
        } catch (UnsupportedOperationException e) {
            System.out.println("copyList.add() threw UnsupportedOperationException as expected.");
        }
    }
}

