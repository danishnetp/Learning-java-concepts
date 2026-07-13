package com.learning.concepts.features.java14.demo;

/**
 * Summarizes G1 NUMA-aware memory allocation improvements in Java 14.
 */
public class G1NumaInfoDemo14 {

    /**
     * Prints high-level details for G1 NUMA improvements.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== G1 GC NUMA-Aware Allocation (Java 14) ===");
        System.out.println("G1 can better respect NUMA locality on large systems.");
        System.out.println("This can improve throughput/latency in multi-socket servers.");
        System.out.println("Processor count: " + Runtime.getRuntime().availableProcessors());
    }
}

