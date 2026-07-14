package com.learning.concepts.java_features.java9.demo;

/**
 * Demonstrates the {@link StackWalker} API introduced in Java 9.
 * <p>
 * StackWalker provides a more efficient and flexible alternative to older
 * stack inspection approaches such as building full stack traces eagerly.
 */
public class StackWalkerDemo {

    /**
     * Starts a short call chain and then prints stack frames.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== StackWalker (Java 9) ===");
        methodA();
    }

    private static void methodA() {
        methodB();
    }

    private static void methodB() {
        StackWalker.getInstance()
                .forEach(frame -> System.out.println(frame.getClassName() + "#" + frame.getMethodName()));
    }
}

