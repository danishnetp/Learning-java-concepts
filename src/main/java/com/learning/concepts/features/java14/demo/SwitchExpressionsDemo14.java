package com.learning.concepts.features.java14.demo;

/**
 * Demonstrates switch expressions, which became a standard feature in Java 14.
 */
public class SwitchExpressionsDemo14 {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Shows both simple and block-based switch expression forms.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Day day = Day.WEDNESDAY;

        String type = switch (day) {
            case SATURDAY, SUNDAY -> "Weekend";
            case MONDAY -> "Start";
            default -> {
                String value = "Weekday";
                yield value;
            }
        };

        int letters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };

        System.out.println("=== Switch Expressions (Standard in Java 14) ===");
        System.out.println("Day: " + day);
        System.out.println("Type: " + type);
        System.out.println("Letters: " + letters);
    }
}

