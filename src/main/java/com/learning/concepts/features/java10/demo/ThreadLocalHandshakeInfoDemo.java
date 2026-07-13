package com.learning.concepts.features.java10.demo;

/**
 * Provides an informational overview of Thread-Local Handshakes, a Java 10
 * JVM internal improvement.
 * <p>
 * Before this change, the JVM needed a global stop-the-world pause to perform
 * operations on individual threads. Thread-local handshakes allow the JVM to
 * stop and perform a callback on a single thread without pausing all others,
 * reducing latency spikes in multi-threaded applications.
 */
public class ThreadLocalHandshakeInfoDemo {

    /**
     * Prints a short description of thread-local handshakes and their
     * benefit over earlier stop-the-world approaches.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Thread-Local Handshakes - Java 10 ===");
        System.out.println("Allows the JVM to stop one thread at a time instead of all threads.");
        System.out.println("Reduces GC and deoptimization pause times.");
        System.out.println("This is a JVM internal feature; no direct API changes are visible.");
    }
}

