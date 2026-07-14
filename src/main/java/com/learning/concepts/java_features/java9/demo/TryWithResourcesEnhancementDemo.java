package com.learning.concepts.java_features.java9.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Demonstrates the Java 9 try-with-resources enhancement.
 * <p>
 * In Java 9, an effectively final resource can be declared before the
 * {@code try} block and then referenced directly inside {@code try (...)},
 * avoiding redundant redeclaration.
 */
public class TryWithResourcesEnhancementDemo {

    /**
     * Reads two lines from an in-memory reader using the Java 9 resource style.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if reading fails
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("line-1\nline-2"));

        System.out.println("=== Try-With-Resources Enhancement (Java 9) ===");
        try (reader) {
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        }
    }
}

