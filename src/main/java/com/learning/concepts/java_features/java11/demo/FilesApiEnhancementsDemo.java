package com.learning.concepts.java_features.java11.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * Demonstrates the Java 11 enhancements to the {@code java.nio.file.Files} API.
 * <p>
 * {@code Files.readString()} and {@code Files.writeString()} simplify reading
 * and writing entire files as strings, eliminating the need for stream code.
 */
public class FilesApiEnhancementsDemo {

    /**
     * Creates a temporary file, writes a string to it, reads it back,
     * and prints the result.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file I/O fails
     */
    public static void main(String[] args) throws IOException {
        Path tempFile = Path.of(System.getProperty("java.io.tmpdir"),
                "java11-demo-" + UUID.randomUUID() + ".txt");

        String content = "Hello from Java 11\nFiles.writeString() is convenient!";

        System.out.println("=== Files API Enhancements - Java 11 ===");

        // Write string to file
        Files.writeString(tempFile, content);
        System.out.println("Written to: " + tempFile);

        // Read string from file
        String readContent = Files.readString(tempFile);
        System.out.println("Read content:\n" + readContent);

        // Append more content
        Files.writeString(tempFile, "\nAppended line", StandardOpenOption.APPEND);
        System.out.println("\nAfter append:\n" + Files.readString(tempFile));

        // Clean up
        Files.delete(tempFile);
    }
}

