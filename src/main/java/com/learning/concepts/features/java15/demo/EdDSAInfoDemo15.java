package com.learning.concepts.features.java15.demo;

import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 * Demonstrates availability of EdDSA algorithm support in Java 15.
 */
public class EdDSAInfoDemo15 {

    /**
     * Prints basic EdDSA availability checks using standard JCA APIs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== EdDSA Support (Java 15) ===");
        try {
            KeyPairGenerator.getInstance("Ed25519");
            Signature.getInstance("Ed25519");
            System.out.println("Ed25519 key generation and signature are available.");
        } catch (Exception e) {
            System.out.println("EdDSA support check failed: " + e.getMessage());
        }
    }
}

