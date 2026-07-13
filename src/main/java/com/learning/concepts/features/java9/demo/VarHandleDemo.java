package com.learning.concepts.features.java9.demo;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * Demonstrates {@link VarHandle}, introduced in Java 9.
 * <p>
 * VarHandle offers typed, safe, and flexible variable access operations that
 * cover many use cases previously associated with lower-level APIs.
 */
public class VarHandleDemo {

    /**
     * Simple mutable holder whose field is accessed through a VarHandle.
     */
    static class Counter {
        volatile int value = 0;
    }

    /**
     * Looks up a VarHandle, performs set and compare-and-set operations, and
     * prints the results.
     *
     * @param args command-line arguments (not used)
     * @throws NoSuchFieldException if the field name changes unexpectedly
     * @throws IllegalAccessException if lookup access is denied
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Counter counter = new Counter();
        VarHandle handle = MethodHandles.lookup().findVarHandle(Counter.class, "value", int.class);

        System.out.println("=== VarHandle (Java 9) ===");
        System.out.println("Initial: " + counter.value);
        handle.set(counter, 5);
        System.out.println("After set: " + counter.value);

        boolean updated = handle.compareAndSet(counter, 5, 10);
        System.out.println("compareAndSet success: " + updated);
        System.out.println("Final: " + counter.value);
    }
}

