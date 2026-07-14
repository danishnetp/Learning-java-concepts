package com.learning.concepts.java_features.java15.demo;

/**
 * Summarizes hidden classes introduced for framework/runtime use cases.
 */
public class HiddenClassesInfoDemo15 {

    /**
     * Prints hidden class purpose and benefits.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Hidden Classes (Java 15) ===");
        System.out.println("Hidden classes are intended for frameworks and dynamic runtime code generation.");
        System.out.println("They are not discoverable as normal classes and can be short-lived.");
        System.out.println("Useful for proxies, lambdas, bytecode-generation libraries.");
    }
}

