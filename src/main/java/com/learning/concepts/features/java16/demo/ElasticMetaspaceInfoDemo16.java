package com.learning.concepts.features.java16.demo;

/**
 * Summarizes Elastic Metaspace improvements in Java 16.
 */
public class ElasticMetaspaceInfoDemo16 {

    /**
     * Prints key benefits of metaspace elasticity.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Elastic Metaspace (Java 16) ===");
        System.out.println("Unused metaspace memory can be returned more aggressively.");
        System.out.println("Benefit: reduced footprint in classloading-heavy applications.");
    }
}

