package com.learning.concepts.java_features.java18.demo;

/**
 * Demonstrates @Deprecated enhancements in Java 18.
 * The @Deprecated annotation now supports 'since' and 'forRemoval' parameters.
 */
public class DeprecatedEnhancementsDemo18 {

    @Deprecated(since = "18", forRemoval = true)
    public static void legacyMethod() {
        System.out.println("This method is deprecated for removal.");
    }

    @Deprecated(since = "17")
    public static void deprecatedSince17() {
        System.out.println("Deprecated since Java 17, but not marked for removal.");
    }

    /**
     * Demonstrates the enhanced @Deprecated annotation usage.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== @Deprecated Enhancements (Java 18) ===");
        System.out.println();

        System.out.println("Enhanced @Deprecated annotation:");
        System.out.println("  - 'since' parameter: specifies Java version of deprecation");
        System.out.println("  - 'forRemoval' parameter: indicates removal in future version");
        System.out.println();

        System.out.println("Example annotations:");
        System.out.println("  @Deprecated(since = \"18\", forRemoval = true)");
        System.out.println("  @Deprecated(since = \"17\")");
        System.out.println();

        System.out.println("Calling deprecated methods (will show compiler warnings):");
        deprecatedSince17();
        legacyMethod();
    }
}

