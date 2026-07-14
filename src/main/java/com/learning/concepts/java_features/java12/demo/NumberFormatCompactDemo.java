package com.learning.concepts.java_features.java12.demo;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Demonstrates compact number formatting introduced in Java 12.
 * <p>
 * {@code NumberFormat.getCompactNumberInstance()} creates a formatter that
 * displays large numbers in compact form (e.g., 1.2M instead of 1200000).
 */
public class NumberFormatCompactDemo {

    /**
     * Shows compact number formatting in SHORT and LONG styles.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        long[] numbers = {1000, 10000, 100000, 1000000, 1200000, 999999999L};

        NumberFormat compactShort = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.SHORT);
        NumberFormat compactLong = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.LONG);

        System.out.println("=== Compact Number Formatting - Java 12 ===");
        System.out.println("SHORT style:");
        for (long num : numbers) {
            System.out.println("  " + num + " -> " + compactShort.format(num));
        }

        System.out.println("\nLONG style:");
        for (long num : numbers) {
            System.out.println("  " + num + " -> " + compactLong.format(num));
        }
    }
}

