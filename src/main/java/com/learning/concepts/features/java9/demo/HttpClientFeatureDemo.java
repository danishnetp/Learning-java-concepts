package com.learning.concepts.features.java9.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Demonstrates the modern HTTP client concept associated with Java 9.
 * <p>
 * Historically, this client first appeared as an incubator API in Java 9.
 * In later Java releases it became the standard {@code java.net.http}
 * package. This demo focuses on the programming model rather than making a
 * live network call.
 */
public class HttpClientFeatureDemo {

    /**
     * Builds a client and request instance, then prints key metadata.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .GET()
                .build();

        System.out.println("=== HTTP Client Feature (Java 9 incubator) ===");
        System.out.println("In Java 9 this started as incubator: jdk.incubator.httpclient");
        System.out.println("Configured client: " + client.version());
        System.out.println("Request URI: " + request.uri());
    }
}

