package com.learning.concepts.features.java9.demo;

/**
 * Provides a quick introduction to JShell, the Java REPL added in Java 9.
 * <p>
 * Because JShell is an external interactive tool rather than a library API,
 * this class prints guidance and example commands instead of embedding a REPL.
 */
public class JShellInfoDemo {

    /**
     * Prints a short explanation and some starter JShell commands.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== JShell (Java 9) ===");
        System.out.println("JShell is Java's REPL tool for interactive coding.");
        System.out.println("Run command: jshell");
        System.out.println("Useful snippets:");
        System.out.println("  int x = 10;");
        System.out.println("  x * 2");
        System.out.println("  /vars");
    }
}

