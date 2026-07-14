package com.learning.concepts.java_features.java9.demo;

/**
 * Explains the multi-release JAR feature introduced in Java 9.
 * <p>
 * Multi-release JARs allow a single archive to contain version-specific class
 * implementations while still supporting older Java runtimes.
 */
public class MultiReleaseJarInfoDemo {

    /**
     * Prints the key folder layout and usage idea behind multi-release JARs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Multi-Release JAR (Java 9) ===");
        System.out.println("Store version-specific classes under:");
        System.out.println("META-INF/versions/<java-version>");
        System.out.println("One JAR can support multiple Java runtimes.");
    }
}

