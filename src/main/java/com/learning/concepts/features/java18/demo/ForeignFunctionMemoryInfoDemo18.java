package com.learning.concepts.features.java18.demo;

/**
 * Provides an overview of the Foreign Function & Memory API (preview in Java 18).
 */
public class ForeignFunctionMemoryInfoDemo18 {

    /**
     * Prints information about Foreign Function & Memory API.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Foreign Function & Memory API (Preview in Java 18) ===");
        System.out.println("Purpose: Safer and more efficient native interoperability.");
        System.out.println();
        System.out.println("Key features:");
        System.out.println("  - FFI (Foreign Function Interface) for calling native code");
        System.out.println("  - Foreign Memory API for off-heap memory access");
        System.out.println("  - Type-safe and better than JNI");
        System.out.println("  - Reduces unsafe memory operations");
        System.out.println();
        System.out.println("Benefits over JNI:");
        System.out.println("  - No native code boilerplate");
        System.out.println("  - Pure Java interop declarations");
        System.out.println("  - Better performance");
        System.out.println();
        System.out.println("Status: Second preview in Java 18, continuing evolution.");
    }
}

