package com.learning.concepts.features.java9.demo;

/**
 * Demonstrates private methods inside interfaces, a Java 9 enhancement.
 * <p>
 * Before Java 9, interfaces could have default and static methods, but any
 * shared helper logic had to be duplicated or moved elsewhere. Java 9 allows
 * private helper methods so multiple default methods can reuse common code.
 */
public class InterfacePrivateMethodDemo {

    /**
     * Uses a private helper method to build multiple public default messages.
     */
    interface Greeting {
        default String morning(String name) {
            return format("Good morning", name);
        }

        default String evening(String name) {
            return format("Good evening", name);
        }

        private String format(String prefix, String name) {
            return prefix + ", " + name;
        }
    }

    static class GreetingService implements Greeting {
    }

    /**
     * Prints greetings produced through default methods that internally call
     * a private interface helper.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Greeting greeting = new GreetingService();
        System.out.println("=== Interface Private Methods (Java 9) ===");
        System.out.println(greeting.morning("Ravi"));
        System.out.println(greeting.evening("Pankaj"));
    }
}

