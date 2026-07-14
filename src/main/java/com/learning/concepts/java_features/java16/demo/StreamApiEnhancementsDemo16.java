package com.learning.concepts.java_features.java16.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates Java 16 Stream API enhancement: {@code Stream.toList()}.
 */
public class StreamApiEnhancementsDemo16 {

    /**
     * Compares {@code Stream.toList()} and {@code Collectors.toUnmodifiableList()}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> viaToList = Stream.of("java", "stream", "api")
                .map(String::toUpperCase)
                .toList();

        List<String> viaCollector = Stream.of("java", "stream", "api")
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableList());

        System.out.println("=== Stream API Enhancements (Java 16) ===");
        System.out.println("Stream.toList():                 " + viaToList);
        System.out.println("Collectors.toUnmodifiableList(): " + viaCollector);
        System.out.println("Both lists are unmodifiable.");

        try {
            viaToList.add("FAIL");
        } catch (UnsupportedOperationException e) {
            System.out.println("Stream.toList() result is unmodifiable as expected.");
        }
    }
}

