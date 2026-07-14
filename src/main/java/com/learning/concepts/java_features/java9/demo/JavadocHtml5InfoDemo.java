package com.learning.concepts.java_features.java9.demo;

/**
 * Highlights JavaDoc improvements in Java 9.
 * <p>
 * JavaDoc output moved toward modern HTML5 and improved search/navigation,
 * making generated API documentation easier to browse.
 */
public class JavadocHtml5InfoDemo {

    /**
     * Prints a short summary and an example JavaDoc command.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== JavaDoc Updates (Java 9) ===");
        System.out.println("JavaDoc output moved to HTML5 by default.");
        System.out.println("Search and navigation were improved.");
        System.out.println("Run: javadoc -d docs src/main/java/... ");
    }
}

