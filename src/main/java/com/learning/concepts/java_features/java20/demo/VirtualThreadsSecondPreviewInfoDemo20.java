package com.learning.concepts.java_features.java20.demo;

/**
 * Provides an overview of virtual threads (second preview in Java 20).
 */
public class VirtualThreadsSecondPreviewInfoDemo20 {

    /**
     * Prints feature purpose and sample syntax.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads (Second Preview in Java 20) ===");
        System.out.println("Purpose: Lightweight threads for highly concurrent workloads.");
        System.out.println("JEP: 436.");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 20.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  Thread vt = Thread.ofVirtual().start(() -> {");
        System.out.println("      System.out.println(\"Running in virtual thread\");");
        System.out.println("  });");
    }
}

