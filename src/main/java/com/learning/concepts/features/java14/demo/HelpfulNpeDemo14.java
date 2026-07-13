package com.learning.concepts.features.java14.demo;

/**
 * Demonstrates the idea behind Helpful NullPointerExceptions in Java 14.
 * <p>
 * Java 14 can include richer context in NPE messages, indicating which part
 * of a dereference chain was null.
 */
public class HelpfulNpeDemo14 {

    static class Address {
        String city;
    }

    static class User {
        Address address;
    }

    /**
     * Triggers and catches an NPE to print the improved message.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        User user = new User();

        System.out.println("=== Helpful NullPointerExceptions (Java 14) ===");
        try {
            // address is null here
            System.out.println(user.address.city.toUpperCase());
        } catch (NullPointerException npe) {
            System.out.println("Caught NPE message:");
            System.out.println(npe.getMessage());
        }
    }
}

