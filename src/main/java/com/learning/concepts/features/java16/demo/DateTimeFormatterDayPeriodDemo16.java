package com.learning.concepts.features.java16.demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Demonstrates Java 16 day-period support in DateTimeFormatter pattern letter {@code B}.
 */
public class DateTimeFormatterDayPeriodDemo16 {

    /**
     * Prints localized day-period text such as morning, afternoon, evening, or night.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        DateTimeFormatter dayPeriodFormatter = DateTimeFormatter.ofPattern("h B", Locale.ENGLISH);
        DateTimeFormatter amPmFormatter = DateTimeFormatter.ofPattern("h a", Locale.ENGLISH);

        List<LocalTime> samples = List.of(
                LocalTime.of(2, 0),
                LocalTime.of(9, 0),
                LocalTime.of(14, 0),
                LocalTime.of(19, 0),
                LocalTime.of(23, 0)
        );

        System.out.println("=== Date/Time Formatting Enhancement (Java 16) ===");
        System.out.println("Pattern 'B' adds flexible day-period text beyond only AM/PM.");

        for (LocalTime time : samples) {
            String withDayPeriod = dayPeriodFormatter.format(time);
            String withAmPm = amPmFormatter.format(time);
            System.out.println(time + " -> B: " + withDayPeriod + " | a: " + withAmPm);
        }
    }
}

