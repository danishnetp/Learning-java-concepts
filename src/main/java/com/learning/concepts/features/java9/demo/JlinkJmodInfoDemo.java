package com.learning.concepts.features.java9.demo;

/**
 * Introduces the Java 9 tooling additions {@code jlink} and {@code jmod}.
 * <p>
 * These tools became especially important after modularization because they
 * support custom runtime creation and modular packaging workflows.
 */
public class JlinkJmodInfoDemo {

    /**
     * Prints a short summary and one example command for {@code jlink}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== jlink and jmod (Java 9) ===");
        System.out.println("jmod creates module artifacts.");
        System.out.println("jlink builds a custom runtime image from modules.");
        System.out.println("Sample: jlink --add-modules java.base --output custom-runtime");
    }
}

