package com.learning.concepts.features.java21.demo;

/**
 * Provides an overview of virtual threads as a standard feature in Java 21.
 */
public class VirtualThreadsStandardInfoDemo21 {

    /**
     * Prints purpose, status, and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads (Standard in Java 21) ===");
        System.out.println("JEP: 444");
        System.out.println("Purpose: Lightweight threads for scalable concurrency.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  Thread.startVirtualThread(() -> System.out.println(\"Hello\"));");
    }
}

