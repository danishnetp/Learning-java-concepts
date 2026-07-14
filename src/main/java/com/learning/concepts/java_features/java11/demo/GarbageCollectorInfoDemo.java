package com.learning.concepts.java_features.java11.demo;

/**
 * Summarizes new garbage collector options in Java 11.
 * <p>
 * Java 11 introduced Epsilon GC (no collection) and ZGC (low-latency) as
 * experimental garbage collectors offering different performance trade-offs.
 */
public class GarbageCollectorInfoDemo {

    /**
     * Prints information about Java 11 GC options and when to use them.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Garbage Collectors in Java 11 ===");
        System.out.println("");
        System.out.println("1. Epsilon GC (no collection)");
        System.out.println("   Flag: -XX:+UseEpsilonGC");
        System.out.println("   Purpose: Performance testing, short-lived apps");
        System.out.println("   Behavior: Allocates memory, never garbage collects");
        System.out.println("");
        System.out.println("2. Z Garbage Collector (ZGC - low latency)");
        System.out.println("   Flag: -XX:+UseZGC");
        System.out.println("   Purpose: Ultra-low pause times (< 10ms)");
        System.out.println("   Heap size: 8MB to 16TB (experimental in Java 11)");
        System.out.println("   Status: Experimental in Java 11");
        System.out.println("");
        System.out.println("Default GC: G1 (still available and improved)");
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    }
}

