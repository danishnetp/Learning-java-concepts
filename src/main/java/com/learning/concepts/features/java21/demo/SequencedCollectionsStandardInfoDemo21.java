package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of sequenced collections as a standard feature in Java 21.
 */
public class SequencedCollectionsStandardInfoDemo21 {

    /**
     * Prints purpose, status, and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sequenced Collections (Standard in Java 21) ===");
        System.out.println("JEP: 431");
        System.out.println("Purpose: Unified first/last/reversed operations on ordered collections.");
        System.out.println();
        System.out.println("Sample operations:");
        System.out.println("  sequencedCollection.getFirst();");
        System.out.println("  sequencedCollection.getLast();");
        System.out.println("  sequencedCollection.reversed();");
    }
}

