package com.learning.concepts.java_features.java19.demo;

/**
 * Provides an overview of virtual threads (preview in Java 19).
 */
public class VirtualThreadsPreviewInfoDemo19 {

    /**
     * Prints virtual thread context and sample usage.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads (Preview in Java 19) ===");
        System.out.println("Purpose: Lightweight threads for high-concurrency applications.");
        System.out.println("Status: Preview in Java 19 (JEP 425).");
        System.out.println("Requires: --enable-preview when compiling/running on JDK 19.");
        System.out.println();
        System.out.println("Sample:");
        System.out.println("  Thread vt = Thread.ofVirtual().start(() -> {");
        System.out.println("      System.out.println(\"Running in virtual thread\");");
        System.out.println("  });");
    }
}

