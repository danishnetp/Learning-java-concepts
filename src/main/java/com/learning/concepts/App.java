package com.learning.concepts;

import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");
        Function<String, String> greet = name -> "Hello, " + name;
    }
}

