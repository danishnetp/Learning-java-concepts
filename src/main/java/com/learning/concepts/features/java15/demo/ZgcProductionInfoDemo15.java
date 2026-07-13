package com.learning.concepts.features.java15.demo;

/**
 * Summarizes ZGC production-ready status in Java 15.
 */
public class ZgcProductionInfoDemo15 {

    /**
     * Prints key notes about ZGC maturation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== ZGC Production-Ready (Java 15) ===");
        System.out.println("ZGC moved from experimental to production-ready status.");
        System.out.println("Use with: -XX:+UseZGC");
        System.out.println("Goal: low-latency GC with small pause times.");
    }
}

