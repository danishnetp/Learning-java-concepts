package com.learning.concepts.java_features.java8.demo.inter_and_abstract;

/**
 * Demonstrates the field-model difference between interfaces and abstract classes.
 * <p>
 * In Java, every field declared in an interface is implicitly {@code public static final},
 * so it behaves like a constant. Abstract classes, on the other hand, can own instance
 * state with normal access modifiers.
 */
public class InterfaceFieldsExample {

    /**
     * Interface constants are always public/static/final, even when omitted.
     */
    interface RetryPolicy {
        // Interface fields are implicitly public static final.
        int MAX_RETRIES = 3;
    }

    /**
     * Abstract class can contain real instance fields and constructors.
     */
    static abstract class AbstractRetryPolicy {
        protected int timeoutMs;
        private final String policyName;

        protected AbstractRetryPolicy(String policyName, int timeoutMs) {
            this.policyName = policyName;
            this.timeoutMs = timeoutMs;
        }

        public String getPolicyName() {
            return policyName;
        }
    }

    static class DefaultRetryPolicy extends AbstractRetryPolicy {
        DefaultRetryPolicy() {
            super("default", 500);
        }
    }

    /**
     * Prints constants from the interface and instance state from the abstract class.
     */
    public static void demonstrate() {
        DefaultRetryPolicy policy = new DefaultRetryPolicy();
        System.out.println("[Fields] Interface constant MAX_RETRIES = " + RetryPolicy.MAX_RETRIES);
        System.out.println("[Fields] Abstract class instance field timeoutMs = " + policy.timeoutMs);
        System.out.println("[Fields] Abstract class private field policyName = " + policy.getPolicyName());
    }
}

