package com.learning.concepts.java_features.java9.demo;

import java.lang.reflect.Method;

/**
 * Demonstrates the enhanced {@link Deprecated} annotation in Java 9.
 * <p>
 * Java 9 added {@code since} and {@code forRemoval} metadata so libraries can
 * communicate deprecation lifecycle more clearly.
 */
public class EnhancedDeprecatedDemo {

    /**
     * Simple nested type containing a deprecated member whose metadata can be
     * inspected reflectively.
     */
    static class Service {
        @Deprecated(since = "9", forRemoval = true)
        public void legacyMethod() {
            System.out.println("legacyMethod called");
        }
    }

    /**
     * Reads deprecation metadata from the sample method via reflection.
     *
     * @param args command-line arguments (not used)
     * @throws NoSuchMethodException if the method name is changed unexpectedly
     */
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Service.class.getDeclaredMethod("legacyMethod");
        Deprecated deprecated = method.getAnnotation(Deprecated.class);

        System.out.println("=== Enhanced @Deprecated (Java 9) ===");
        System.out.println("since: " + deprecated.since());
        System.out.println("forRemoval: " + deprecated.forRemoval());
    }
}

