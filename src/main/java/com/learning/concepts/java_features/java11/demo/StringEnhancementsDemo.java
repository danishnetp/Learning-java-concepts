package com.learning.concepts.java_features.java11.demo;

/**
 * Demonstrates new {@code String} methods introduced in Java 11.
 * <p>
 * Java 11 added four convenient methods for common string operations:
 * <ul>
 *   <li>{@code isBlank()} - checks if a string is empty or contains only whitespace</li>
 *   <li>{@code strip()} - removes leading and trailing whitespace (Unicode-aware)</li>
 *   <li>{@code lines()} - returns a stream of lines in a multi-line string</li>
 *   <li>{@code repeat(int)} - repeats the string n times</li>
 * </ul>
 * <p>
 * Note: {@code strip()} is Unicode-aware and handles all Unicode whitespace,
 * while {@code trim()} (pre-Java 11) only handles ASCII whitespace.
 */
public class StringEnhancementsDemo {

    /**
     * Demonstrates each of the four new String methods with detailed output
     * showing the before/after behavior and use cases.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String text = "  Hello Java 11  ";
        String multiline = "Line 1\nLine 2\nLine 3";
        String word = "Java";

        System.out.println("=== String Enhancements - Java 11 ===\n");

        // 1. isBlank() - Checks if string is empty or contains only whitespace
        System.out.println("1. isBlank() - Checks if a string is empty or contains only whitespace");
        System.out.println("   Functionality: Returns true if the string has zero length or");
        System.out.println("   contains only whitespace characters (spaces, tabs, newlines, etc.)");
        System.out.println("   Original: '" + text + "'");
        System.out.println("   isBlank(): " + text.isBlank() + " (contains non-whitespace text)");
        System.out.println("   '   '.isBlank() = " + "   ".isBlank() + " (only whitespace)");
        System.out.println("   ''.isBlank() = " + "".isBlank() + " (empty string)\n");

        // 2. strip() - Removes leading and trailing whitespace (Unicode-aware)
        System.out.println("2. strip() - Removes leading and trailing whitespace");
        System.out.println("   Functionality: Unicode-aware version of trim().");
        System.out.println("   Removes all leading and trailing whitespace characters.");
        System.out.println("   Unlike trim(), it handles all Unicode whitespace, not just ASCII.");
        System.out.println("   Original: '" + text + "' (length = " + text.length() + ")");
        System.out.println("   strip(): '" + text.strip() + "' (length = " + text.strip().length() + ")\n");

        // 3. stripLeading() - Removes only leading whitespace
        System.out.println("3. stripLeading() - Removes only leading whitespace");
        System.out.println("   Functionality: Removes whitespace from the beginning of the string only.");
        System.out.println("   Trailing whitespace is preserved.");
        System.out.println("   Original: '" + text + "'");
        System.out.println("   stripLeading(): '" + text.stripLeading() + "'\n");

        // 4. stripTrailing() - Removes only trailing whitespace
        System.out.println("4. stripTrailing() - Removes only trailing whitespace");
        System.out.println("   Functionality: Removes whitespace from the end of the string only.");
        System.out.println("   Leading whitespace is preserved.");
        System.out.println("   Original: '" + text + "'");
        System.out.println("   stripTrailing(): '" + text.stripTrailing() + "'\n");

        // 5. lines() - Returns a stream of lines from multi-line string
        System.out.println("5. lines() - Returns a stream of lines from a multi-line string");
        System.out.println("   Functionality: Splits the string by line separators (\\n, \\r, \\r\\n)");
        System.out.println("   Returns a Stream<String> for convenient processing.");
        System.out.println("   Useful for processing files or multi-line text.");
        System.out.println("   Original multiline string has 3 lines:");
        multiline.lines().forEach(line -> System.out.println("     - " + line));
        System.out.println();

        // 6. repeat() - Repeats the string n times
        System.out.println("6. repeat(int) - Repeats the string n times");
        System.out.println("   Functionality: Returns a new string that concatenates the original");
        System.out.println("   string n times. Useful for generating repeated patterns.");
        System.out.println("   Original word: '" + word + "'");
        System.out.println("   word.repeat(3): '" + word.repeat(3) + "'");
        System.out.println("   word.repeat(0): '" + word.repeat(0) + "' (empty string)");
        System.out.println("   word.repeat(1): '" + word.repeat(1) + "' (original string)\n");

        // Comparison: strip() vs trim()
        System.out.println("Bonus: strip() vs trim() comparison");
        System.out.println("   Both remove leading/trailing whitespace, but strip() is Unicode-aware.");
        String testStr = "  Hello  ";
        System.out.println("   Original: '" + testStr + "'");
        System.out.println("   strip(): '" + testStr.strip() + "'");
        System.out.println("   trim(): '" + testStr.trim() + "'");
        System.out.println("   (For ASCII spaces, both produce the same result)");
    }
}

