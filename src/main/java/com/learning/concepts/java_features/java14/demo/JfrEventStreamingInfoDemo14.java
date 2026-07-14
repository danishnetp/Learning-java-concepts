package com.learning.concepts.java_features.java14.demo;

/**
 * Describes Java Flight Recorder event streaming support in Java 14.
 */
public class JfrEventStreamingInfoDemo14 {

    /**
     * Prints a summary and example command for JFR usage.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== JFR Event Streaming (Java 14) ===");
        System.out.println("Java Flight Recorder supports near real-time event streaming.");
        System.out.println("Useful for low-overhead diagnostics and observability pipelines.");
        System.out.println("Sample runtime flag: -XX:StartFlightRecording=filename=app.jfr,dumponexit=true");
    }
}

