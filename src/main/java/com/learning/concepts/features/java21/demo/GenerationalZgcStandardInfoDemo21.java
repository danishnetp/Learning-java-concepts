package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of Generational ZGC in Java 21.
 */
public class GenerationalZgcStandardInfoDemo21 {

    /**
     * Prints purpose, status, and command-line hint.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Generational ZGC (Standard in Java 21) ===");
        System.out.println("JEP: 439");
        System.out.println("Purpose: Improve throughput and memory behavior for many applications.");
        System.out.println();
        System.out.println("Enable with JVM options:");
        System.out.println("  -XX:+UseZGC -XX:+ZGenerational");
    }
}

