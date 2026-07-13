package com.learning.concepts.features.java13.demo;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

/**
 * Demonstrates archive file system creation with Java NIO.
 * <p>
 * Java 13 added a convenience overload around path-based newFileSystem usage,
 * reducing boilerplate when opening ZIP/JAR file systems.
 */
public class FileSystemsPathDemo {

    /**
     * Creates a temporary ZIP file system, writes a file inside it, and reads
     * that file back.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file system operations fail
     */
    public static void main(String[] args) throws IOException {
        Path zipPath = Path.of(System.getProperty("java.io.tmpdir"), "zip-demo-" + UUID.randomUUID() + ".zip");

        URI zipUri = URI.create("jar:" + zipPath.toUri());
        try (FileSystem zipFs = FileSystems.newFileSystem(zipUri, Map.of("create", "true"))) {
            Path fileInZip = zipFs.getPath("/notes.txt");
            Files.writeString(fileInZip, "Hello from ZIP file system");
            String content = Files.readString(fileInZip);

            System.out.println("=== FileSystems newFileSystem Path Convenience (Java 13) ===");
            System.out.println("ZIP path: " + zipPath);
            System.out.println("Content in ZIP: " + content);
        } finally {
            Files.deleteIfExists(zipPath);
        }
    }
}

