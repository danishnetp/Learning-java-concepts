package com.learning.concepts.features.java13.demo;

/**
 * Demonstrates switch expressions with the {@code yield} keyword.
 * <p>
 * Switch expressions were in second preview state in Java 13 and adopted
 * `yield` for returning values from block cases.
 */
public class SwitchExpressionYieldDemo {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Prints values returned by switch expressions using both arrow and block
     * cases with {@code yield}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Day day = Day.WEDNESDAY;

        String dayType = switch (day) {
            case SATURDAY, SUNDAY -> "Weekend";
            case MONDAY -> "Start of week";
            default -> {
                String result = "Weekday";
                yield result;
            }
        };

        int letters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> {
                int value = 9;
                yield value;
            }
        };

        System.out.println("=== Switch Expressions + yield (Java 13 Preview) ===");
        System.out.println("Day: " + day);
        System.out.println("Day type: " + dayType);
        System.out.println("Computed letters: " + letters);
    }
}

