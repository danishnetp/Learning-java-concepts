package com.learning.concepts.features.java10.demo;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Demonstrates {@code Optional.orElseThrow()} introduced in Java 10.
 * <p>
 * This zero-argument overload is equivalent to {@code Optional.get()} but
 * has a more explicit and intention-revealing name. It throws
 * {@link NoSuchElementException} when the Optional is empty.
 */
public class OptionalOrElseThrowDemo {

    /**
     * Shows the happy path (value present) and the exception path (empty
     * Optional) for {@code orElseThrow()}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Optional<String> present = Optional.of("Java10");
        Optional<String> empty = Optional.empty();

        System.out.println("=== Optional.orElseThrow() - Java 10 ===");

        // Happy path
        String value = present.orElseThrow();
        System.out.println("Value present: " + value);

        // Empty path — throws NoSuchElementException
        try {
            empty.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("empty.orElseThrow() threw NoSuchElementException as expected.");
        }
    }
}

