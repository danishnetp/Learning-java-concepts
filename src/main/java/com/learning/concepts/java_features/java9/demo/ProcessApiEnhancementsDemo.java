package com.learning.concepts.java_features.java9.demo;

/**
 * Demonstrates Process API improvements introduced in Java 9.
 * <p>
 * The {@link ProcessHandle} API makes it easier to inspect the current process,
 * its parent, child processes, and lifecycle information.
 */
public class ProcessApiEnhancementsDemo {

    /**
     * Prints a few details about the current Java process.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ProcessHandle current = ProcessHandle.current();

        System.out.println("=== Process API Enhancements (Java 9) ===");
        System.out.println("Current PID: " + current.pid());
        System.out.println("Parent PID: " + current.parent().map(ProcessHandle::pid).orElse(-1L));
        System.out.println("Children count: " + current.children().count());
        System.out.println("Is alive: " + current.isAlive());
    }
}

