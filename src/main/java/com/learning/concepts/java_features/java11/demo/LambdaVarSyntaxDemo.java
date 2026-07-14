package com.learning.concepts.java_features.java11.demo;

import java.util.function.BiFunction;

/**
 * Demonstrates the use of {@code var} keyword in lambda parameter declarations,
 * introduced in Java 11.
 * <p>
 * Before Java 11, lambda parameters could not use {@code var}. Java 11 extends
 * this feature to allow {@code var} in lambdas, enabling modifiers like
 * {@code final} and improving consistency with local variables.
 */
public class LambdaVarSyntaxDemo {

    /**
     * Shows lambda expressions using {@code var} for parameter declarations
     * and demonstrates how modifiers can be applied.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Lambda with var (Java 11+)
        BiFunction<Integer, Integer, Integer> add = (var x, var y) -> x + y;

        // Lambda with var and final
        BiFunction<Integer, Integer, Integer> multiply = (final var a, final var b) -> a * b;

        System.out.println("=== Lambda var Syntax - Java 11 ===");
        System.out.println("add(5, 3) = " + add.apply(5, 3));
        System.out.println("multiply(4, 7) = " + multiply.apply(4, 7));
    }
}

