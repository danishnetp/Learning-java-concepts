package com.learning.concepts.java_features.java16.demo;

/**
 * Demonstrates records as a standard feature in Java 16.
 */
public class RecordsStandardDemo16 {

    record User(String name, int age) {
        public User {
            if (age <= 18) {
                throw new IllegalArgumentException("age must be greater than 18");
            }
        }
    }

    /**
     * Creates and prints record instances and generated accessor behavior.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        User user1 = new User("Ravi", 28);
        User user2 = new User("Ravi", 28);

        System.out.println("=== Records (Standard in Java 16) ===");
        System.out.println("Record instance: " + user1);
        System.out.println("Accessor name(): " + user1.name());
        System.out.println("Accessor age(): " + user1.age());
        System.out.println("equals generated automatically: " + user1.equals(user2));
        System.out.println("hashCode generated automatically: " + user1.hashCode());
    }
}

