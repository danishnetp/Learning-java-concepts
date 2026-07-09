package com.learning.concepts;

public class App {
    public static String greeting(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Gradle";
        System.out.println(greeting(name));
    }
}

