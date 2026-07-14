package com.learning.concepts.java_features.java18.demo;

/**
 * Provides an overview of virtual threads (first preview in Java 18) via Project Loom.
 * Virtual threads are lightweight, user-mode threads for concurrent applications.
 *
 * Note: Virtual threads require --enable-preview flag to compile and run in Java 18.
 */
public class VirtualThreadsPreviewDemo18 {

    /**
     * Demonstrates the concept of virtual threads.
     * To run this with actual virtual threads, use: java --enable-preview
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads (Preview in Java 18) ===");
        System.out.println();

        System.out.println("Virtual threads are lightweight, user-mode threads.");
        System.out.println("They greatly simplify concurrent programming.");
        System.out.println();

        System.out.println("Creating virtual threads (requires --enable-preview):");
        System.out.println("  Thread vt = Thread.ofVirtual().start(() -> {");
        System.out.println("      System.out.println(\"Running on virtual thread\");");
        System.out.println("  });");
        System.out.println();

        System.out.println("Benefits of virtual threads:");
        System.out.println("  - Create millions without platform thread overhead");
        System.out.println("  - Simplified async/concurrent programming");
        System.out.println("  - Easier error handling and debugging");
        System.out.println("  - Structured concurrency support");
        System.out.println();

        System.out.println("Comparison:");
        System.out.println("  Platform threads: Limited by OS resources (~1000 per JVM)");
        System.out.println("  Virtual threads: Can create millions (~100,000,000+)");
        System.out.println();

        System.out.println("Status: First preview in Java 18.");
        System.out.println("To use: Compile with --enable-preview");
        System.out.println("        Run with --enable-preview");
    }
}

