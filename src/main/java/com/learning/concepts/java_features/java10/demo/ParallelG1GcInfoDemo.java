package com.learning.concepts.java_features.java10.demo;

/**
 * Summarizes G1 parallel full GC improvement in Java 10.
 * <p>
 * Prior to Java 10, a full GC triggered by G1 was single-threaded which
 * caused long pause times. Java 10 made G1 full GC parallel, using the same
 * number of threads as concurrent GC.
 */
public class ParallelG1GcInfoDemo {

    /**
     * Prints a summary of the G1 parallel full GC improvement and how to
     * control the number of GC threads.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Parallel Full GC for G1 - Java 10 ===");
        System.out.println("G1 GC full collection is now parallel (was single-threaded before).");
        System.out.println("Reduces worst-case pause time for large heaps.");
        System.out.println("Control threads with: -XX:ParallelGCThreads=<n>");
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    }
}

