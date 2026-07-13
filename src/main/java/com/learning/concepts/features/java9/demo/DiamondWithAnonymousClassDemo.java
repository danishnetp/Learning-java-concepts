package com.learning.concepts.features.java9.demo;

import java.util.ArrayList;

/**
 * Demonstrates improved support for the diamond operator with anonymous
 * classes in Java 9.
 * <p>
 * This reduces verbosity when creating anonymous subclasses of generic types.
 */
public class DiamondWithAnonymousClassDemo {

    /**
     * Creates an anonymous {@link ArrayList} using the diamond operator and
     * prints the populated collection.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>() {
            {
                add("Ravi");
                add("Pankaj");
            }
        };

        System.out.println("=== Diamond With Anonymous Class (Java 9) ===");
        System.out.println(names);
    }
}

