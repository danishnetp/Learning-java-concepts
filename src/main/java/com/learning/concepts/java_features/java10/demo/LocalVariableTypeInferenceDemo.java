package com.learning.concepts.java_features.java10.demo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Demonstrates local variable type inference using {@code var}, introduced in Java 10.
 * <p>
 * {@code var} tells the compiler to infer the type from the right-hand side
 * of the assignment. The type is still static — it is determined at compile
 * time and cannot change. It can only be used for local variables, enhanced
 * for-loop variables, and try-with-resources variables.
 */
public class LocalVariableTypeInferenceDemo {

    /**
     * Shows {@code var} used with different types including collections,
     * primitives, and maps.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Compiler infers ArrayList<String>
        var names = new ArrayList<String>();
        names.add("Ravi");
        names.add("Pankaj");

        // Compiler infers int
        var count = names.size();

        // Compiler infers Map.Entry iteration type
        var map = new HashMap<String, Integer>();
        map.put("Java", 10);
        map.put("Spring", 6);

        System.out.println("=== Local Variable Type Inference (var) - Java 10 ===");
        System.out.println("names: " + names);
        System.out.println("count: " + count);

        for (var entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

