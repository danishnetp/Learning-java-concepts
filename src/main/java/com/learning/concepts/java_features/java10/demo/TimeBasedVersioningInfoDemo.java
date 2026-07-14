package com.learning.concepts.java_features.java10.demo;

/**
 * Explains the time-based release versioning system introduced in Java 10.
 * <p>
 * Java adopted a 6-month release cadence beginning with Java 9/10. The new
 * version format is {@code $FEATURE.$INTERIM.$UPDATE.$PATCH} and replaces
 * the older major.minor scheme. This class demonstrates how to read the
 * current runtime version programmatically.
 */
public class TimeBasedVersioningInfoDemo {

    /**
     * Prints the current JVM version using the {@link Runtime.Version} API
     * added in Java 9 and further clarified in Java 10.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();

        System.out.println("=== Time-Based Release Versioning - Java 10 ===");
        System.out.println("Current JVM version: " + version);
        System.out.println("Feature version:     " + version.feature());
        System.out.println("Interim version:     " + version.interim());
        System.out.println("Update version:      " + version.update());
        System.out.println("Patch version:       " + version.patch());
        System.out.println("Format: FEATURE.INTERIM.UPDATE.PATCH (e.g. 10.0.2.0)");
    }
}

