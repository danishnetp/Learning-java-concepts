package com.learning.concepts.java_features.java17.demo;

import java.util.random.RandomGenerator;

/**
 * Demonstrates the enhanced pseudo-random generator API in Java 17.
 */
public class RandomGeneratorApiDemo17 {

    /**
     * Creates random generators using new API and prints sample values.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        RandomGenerator defaultGen = RandomGenerator.getDefault();
        RandomGenerator lxmGen = RandomGenerator.of("L128X256MixRandom");

        System.out.println("=== RandomGenerator API (Java 17) ===");
        System.out.println("Default algorithm: " + defaultGen.getClass().getSimpleName());
        System.out.println("Default nextInt(100): " + defaultGen.nextInt(100));
        System.out.println("LXM nextInt(100): " + lxmGen.nextInt(100));
        System.out.println("LXM nextDouble(): " + lxmGen.nextDouble());
    }
}

