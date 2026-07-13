package com.learning.concepts.features.java11.demo;

/**
 * Explains nest-based access control, a Java 11 JVM feature.
 * <p>
 * Nest-based access allows nested classes (inner classes) to access each
 * other's private members without requiring synthetic accessor methods.
 * This is a JVM-level optimization with no syntax changes visible to source code.
 */
public class NestBasedAccessControlInfoDemo {

    private String outerPrivate = "outer private member";

    /**
     * Inner class that can access outer class private members directly in
     * Java 11 via nest-based access (no synthetic bridge methods needed).
     */
    private class InnerClass {
        void accessOuter() {
            System.out.println("Inner accessing: " + outerPrivate);
        }
    }

    /**
     * Demonstrates nest-based access and prints information about the feature.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        var demo = new NestBasedAccessControlInfoDemo();
        var inner = demo.new InnerClass();

        System.out.println("=== Nest-Based Access Control - Java 11 ===");
        inner.accessOuter();
        System.out.println("");
        System.out.println("Java 11 introduces 'nest' concept for nested classes.");
        System.out.println("Allows seamless private member access between:");
        System.out.println("  - Outer and inner classes");
        System.out.println("  - Inner classes of the same outer class");
        System.out.println("");
        System.out.println("Benefit: Eliminates synthetic bridge methods,");
        System.out.println("reducing class file size and improving performance.");
        System.out.println("No syntax changes; works behind the scenes.");
    }
}

