package com.learning.concepts.features.java11.demo;

/**
 * Describes single-file source code execution, a convenience feature in Java 11.
 * <p>
 * The {@code java} command can directly execute Java source files without an
 * explicit compilation step. This is useful for scripts, short programs, and
 * rapid prototyping.
 */
public class SingleFileSourceCodeInfoDemo {

    /**
     * Prints information about running single-file Java programs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Single File Source Code Execution - Java 11 ===");
        System.out.println("Java 11 allows running .java files directly:");
        System.out.println("  java MyScript.java");
        System.out.println("No need to compile with javac first!");
        System.out.println("");
        System.out.println("Useful for:");
        System.out.println("  - Quick scripts and utilities");
        System.out.println("  - Learning and teaching");
        System.out.println("  - Rapid prototyping");
        System.out.println("");
        System.out.println("Behind the scenes, java compiles the source in memory");
        System.out.println("and runs it immediately.");
    }
}

