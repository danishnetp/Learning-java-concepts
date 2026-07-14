package com.learning.concepts.java_features.java8.demo.inter_and_abstract;

/**
 * Shows lambda compatibility with functional interfaces and contrasts it with
 * abstract classes, which still require subclass/anonymous-class instantiation.
 */
public class FunctionalInterfaceLambdaExample {

    @FunctionalInterface
    interface Calculator {
        int apply(int left, int right);

        default int applyTwice(int left, int right) {
            return apply(left, right) + apply(left, right);
        }
    }

    static abstract class AbstractCalculator {
        abstract int apply(int left, int right);
    }

    /**
     * Uses a lambda for the interface and an anonymous class for the abstract class.
     */
    public static void demonstrate() {
        // Lambda works because Calculator is a functional interface.
        Calculator adder = (left, right) -> left + right;

        // Abstract classes cannot be instantiated with lambda syntax.
        AbstractCalculator subtractor = new AbstractCalculator() {
            @Override
            int apply(int left, int right) {
                return left - right;
            }
        };

        System.out.println("[Lambda] Functional interface via lambda = " + adder.apply(4, 3));
        System.out.println("[Lambda] Functional interface default method = " + adder.applyTwice(4, 3));
        System.out.println("[Lambda] Abstract class via anonymous class = " + subtractor.apply(4, 3));
    }
}

