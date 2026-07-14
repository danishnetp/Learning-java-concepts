package com.learning.concepts.java_features.java18.demo;

import java.nio.charset.Charset;

/**
 * Demonstrates UTF-8 as default charset in Java 18.
 * UTF-8 is now the default on all platforms, improving cross-platform compatibility.
 */
public class Utf8CharsetDemo18 {

    /**
     * Shows UTF-8 as the default charset and compares with explicit encoding.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== UTF-8 by Default (Java 18) ===");
        System.out.println();

        // Get default charset
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("Default Charset: " + defaultCharset);
        System.out.println("Is UTF-8: " + defaultCharset.name().equals("UTF-8"));
        System.out.println();

        // Demonstrate with multi-byte characters
        String multiLang = "Hello 世界 Привет العالم مرحبا";
        System.out.println("Multi-language string:");
        System.out.println("  " + multiLang);
        System.out.println();

        // Encode and decode with UTF-8
        byte[] encoded = multiLang.getBytes(defaultCharset);
        String decoded = new String(encoded, defaultCharset);
        System.out.println("Encoded bytes: " + encoded.length);
        System.out.println("Decoded matches original: " + decoded.equals(multiLang));
        System.out.println();

        System.out.println("Benefits of UTF-8 by default:");
        System.out.println("  - Consistent behavior across all platforms");
        System.out.println("  - Better support for international characters");
        System.out.println("  - Eliminates platform-dependent charset issues");
    }
}

