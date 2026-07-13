package com.learning.concepts.features.java11.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Demonstrates the finalized HttpClient API in Java 11.
 * <p>
 * The HTTP client was introduced as an incubator module in Java 9 and 10.
 * In Java 11, it was finalized and moved to the standard {@code java.net.http}
 * module, making it a standard part of the Java platform.
 */
public class HttpClientFinalizedDemo {

    /**
     * Creates an HTTP client and request, demonstrating the stable Java 11 API.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.example.com"))
                .GET()
                .build();

        System.out.println("=== HttpClient Finalized API - Java 11 ===");
        System.out.println("HttpClient version: " + client.version());
        System.out.println("Request URI: " + request.uri());
        System.out.println("Request method: " + request.method());
        System.out.println("HttpClient is now part of java.net.http module.");
        System.out.println("(In Java 11, it transitioned from incubator to standard API)");
    }
}

