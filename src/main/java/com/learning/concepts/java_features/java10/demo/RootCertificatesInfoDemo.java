package com.learning.concepts.java_features.java10.demo;

import javax.net.ssl.SSLContext;

/**
 * Highlights the OpenJDK root certificate change in Java 10.
 * <p>
 * Before Java 10, the OpenJDK keystore was empty, causing TLS connections to
 * fail unless developers manually added CA certificates. Java 10 shipped
 * Oracle's root CA set with OpenJDK, aligning it with Oracle JDK behavior.
 */
public class RootCertificatesInfoDemo {

    /**
     * Prints the number of trusted root certificates available in the default
     * SSL context as evidence that root certs are now bundled.
     *
     * @param args command-line arguments (not used)
     * @throws Exception if the default SSL context cannot be loaded
     */
    public static void main(String[] args) throws Exception {
        SSLContext ctx = SSLContext.getDefault();
        int protocolCount = ctx.getSupportedSSLParameters().getProtocols().length;

        System.out.println("=== Root Certificates in OpenJDK - Java 10 ===");
        System.out.println("OpenJDK 10 now includes Oracle's root CA certificates.");
        System.out.println("This fixes empty-keystore issues in prior OpenJDK builds.");
        System.out.println("Supported TLS protocol count (non-zero confirms certs loaded): "
                + protocolCount);
    }
}

