package com.learning.concepts.java_features.java12.demo;

/**
 * Demonstrates switch expressions, a preview feature in Java 12.
 * <p>
 * Switch expressions allow using switch as an expression that yields a value,
 * with a cleaner arrow syntax for case labels. Multiple cases can share a label.
 * All code paths must yield a value or use default.
 */
public class SwitchExpressionDemo {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Shows switch expressions with both simple arrows and complex yields.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Day day = Day.FRIDAY;

        // Simple switch expression with arrow syntax
        String dayType = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "Mix";
            case TUESDAY -> "7-letter day";
            case THURSDAY, SATURDAY -> "Mix";
            case WEDNESDAY -> "Longest";
        };

        // Switch expression with complex logic (yield)
        int letters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 6;
            case WEDNESDAY -> {
                int value = 8;
                yield value;
            }
        };

        System.out.println("=== Switch Expressions (Preview) - Java 12 ===");
        System.out.println("Day: " + day);
        System.out.println("Day type: " + dayType);
        System.out.println("Letters in name: " + letters);
    }
}

