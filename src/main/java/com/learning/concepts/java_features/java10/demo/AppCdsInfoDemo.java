package com.learning.concepts.java_features.java10.demo;

/**
 * Provides an informational overview of Application Class-Data Sharing (AppCDS)
 * introduced in Java 10.
 * <p>
 * AppCDS extends the existing Class-Data Sharing (CDS) mechanism so that
 * application classes (not just JDK classes) can be stored in a shared
 * archive. This reduces startup time and heap memory footprint when multiple
 * JVM processes share the same archive.
 */
public class AppCdsInfoDemo {

    /**
     * Prints the purpose of AppCDS and example JVM commands to create and
     * use a shared class archive.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Application Class-Data Sharing (AppCDS) - Java 10 ===");
        System.out.println("Purpose: reduce startup time and memory by sharing class metadata.");
        System.out.println("Step 1 - Dump shared archive:");
        System.out.println("  java -Xshare:dump -XX:SharedClassListFile=classlist \\");
        System.out.println("       -XX:SharedArchiveFile=app.jsa -cp app.jar");
        System.out.println("Step 2 - Run with shared archive:");
        System.out.println("  java -Xshare:on -XX:SharedArchiveFile=app.jsa -jar app.jar");
    }
}

