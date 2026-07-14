package com.learning.concepts.java_features.java9.demo;

/**
 * Summarizes Ahead-Of-Time compilation support introduced experimentally in
 * Java 9.
 * <p>
 * The {@code jaotc} tool was added as an experiment and is useful to mention
 * historically even though support differs across JDK versions.
 */
public class AotCompilationInfoDemo {

    /**
     * Prints the purpose and limitations of the Java 9 AOT tool.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== AOT Compilation (Java 9 experimental) ===");
        System.out.println("Java 9 introduced experimental jaotc tool.");
        System.out.println("Purpose: ahead-of-time compilation of bytecode.");
        System.out.println("Note: support and availability vary by JDK version.");
    }
}

