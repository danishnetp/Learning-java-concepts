package com.learning.concepts.features.java14.demo;

/**
 * Summarizes notable removals in Java 14.
 */
public class RemovedFeaturesInfoDemo14 {

    /**
     * Prints key removed components and modern alternatives.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Removed Features in Java 14 ===");
        System.out.println("- CMS garbage collector removed.");
        System.out.println("  Alternatives: G1, ZGC, Shenandoah.");
        System.out.println("- Pack200 tools/API removed (pack200/unpack200).");
        System.out.println("  Alternatives: modern compression/distribution pipelines.");
    }
}

