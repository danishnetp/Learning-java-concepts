package com.learning.concepts.features.java13.demo;

/**
 * Summarizes ZGC uncommit support in Java 13.
 * <p>
 * Java 13 enhanced ZGC so it can return unused heap memory back to the OS,
 * helping applications with bursty or changing memory requirements.
 */
public class ZgcUncommitInfoDemo {

    /**
     * Prints ZGC uncommit concept and relevant JVM flags.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== ZGC Uncommit Unused Memory (Java 13) ===");
        System.out.println("Use ZGC with: -XX:+UseZGC");
        System.out.println("ZGC can now return unused heap pages to the OS.");
        System.out.println("This reduces idle memory footprint in long-running apps.");
    }
}

