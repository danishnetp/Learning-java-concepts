package com.learning.concepts.java_features.java12.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Demonstrates the {@code Files.mismatch(Path, Path)} method introduced in Java 12.
 * <p>
 * {@code mismatch()} finds the byte position of the first mismatch between two files,
 * or returns -1L if the files are identical. Useful for file comparison and verification.
 */
public class FilesMismatchDemo {

    /**
     * Creates two temporary files, compares them, and shows mismatch positions.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file I/O fails
     */
    public static void main(String[] args) throws IOException {
        Path tempDir = Path.of(System.getProperty("java.io.tmpdir"));
        Path file1 = tempDir.resolve("file1-" + UUID.randomUUID() + ".txt");
        Path file2 = tempDir.resolve("file2-" + UUID.randomUUID() + ".txt");
        Path file3 = tempDir.resolve("file3-" + UUID.randomUUID() + ".txt");

        try {
            // Create identical files
            Files.writeString(file1, "Hello World");
            Files.writeString(file3, "Hello World");

            // Create a different file
            Files.writeString(file2, "Hello Java");

            System.out.println("=== Files.mismatch(Path, Path) - Java 12 ===");

            // Compare identical files
            long mismatch1 = Files.mismatch(file1, file3);
            System.out.println("Comparing identical files:");
            System.out.println("  file1 vs file3: " + (mismatch1 == -1L ? "Identical (-1)" : "Mismatch at byte " + mismatch1));

            // Compare different files
            long mismatch2 = Files.mismatch(file1, file2);
            System.out.println("\nComparing different files:");
            System.out.println("  file1: '" + Files.readString(file1) + "'");
            System.out.println("  file2: '" + Files.readString(file2) + "'");
            System.out.println("  Mismatch at byte position: " + mismatch2);
            System.out.println("  (byte at position " + mismatch2 + " differs)");
        } finally {
            // Clean up
            Files.deleteIfExists(file1);
            Files.deleteIfExists(file2);
            Files.deleteIfExists(file3);
        }
    }
}

