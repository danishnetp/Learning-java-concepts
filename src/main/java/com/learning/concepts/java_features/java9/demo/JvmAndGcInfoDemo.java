package com.learning.concepts.java_features.java9.demo;

/**
 * Summarizes notable JVM and runtime changes delivered with Java 9.
 * <p>
 * These changes are mostly platform-level rather than object-level APIs, so
 * the sample focuses on explanatory output and useful commands.
 */
public class JvmAndGcInfoDemo {

    /**
     * Prints a short summary of JVM logging, GC, and memory-related changes.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== JVM/GC Notes (Java 9) ===");
        System.out.println("Unified JVM logging introduced: use -Xlog");
        System.out.println("G1 became default garbage collector in Java 9.");
        System.out.println("Compact Strings reduce memory for Latin-1 text.");
        System.out.println("Try: java -Xlog:gc -version");
    }
}

