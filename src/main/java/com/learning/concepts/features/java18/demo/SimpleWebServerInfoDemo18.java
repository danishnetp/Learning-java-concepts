package com.learning.concepts.features.java18.demo;

/**
 * Provides an overview of the Simple Web Server (incubator in Java 18).
 */
public class SimpleWebServerInfoDemo18 {

    /**
     * Prints information about the Simple Web Server.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Simple Web Server (Incubator in Java 18) ===");
        System.out.println("Purpose: Lightweight single-file HTTP server for testing.");
        System.out.println();

        System.out.println("Features:");
        System.out.println("  - Zero-configuration HTTP server");
        System.out.println("  - Serves static content");
        System.out.println("  - Useful for development and testing");
        System.out.println("  - Command-line tool: jwebserver");
        System.out.println();

        System.out.println("Command-line usage:");
        System.out.println("  jwebserver [-p 8000]      # Start on port 8000");
        System.out.println("  jwebserver [-d /path]     # Serve from /path");
        System.out.println("  jwebserver [-b 127.0.0.1] # Bind to specific address");
        System.out.println();

        System.out.println("Default behavior:");
        System.out.println("  - Port: 8000");
        System.out.println("  - Bind address: 127.0.0.1");
        System.out.println("  - Directory: current directory");
        System.out.println();

        System.out.println("Status: Incubating API in Java 18.");
    }
}

