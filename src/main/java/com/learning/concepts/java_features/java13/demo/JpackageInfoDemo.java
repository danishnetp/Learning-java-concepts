package com.learning.concepts.java_features.java13.demo;

/**
 * Describes the incubating jpackage tool in Java 13.
 * <p>
 * jpackage creates native installers and app images for target platforms,
 * simplifying desktop distribution.
 */
public class JpackageInfoDemo {

    /**
     * Prints common jpackage usage examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== jpackage Tool (Incubator in Java 13) ===");
        System.out.println("Example (Windows MSI):");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type msi");
        System.out.println("Example (app image):");
        System.out.println("  jpackage --name MyApp --input libs --main-jar app.jar --type app-image");
    }
}

