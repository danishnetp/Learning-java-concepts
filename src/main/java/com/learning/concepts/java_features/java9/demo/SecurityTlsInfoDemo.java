package com.learning.concepts.java_features.java9.demo;

import javax.net.ssl.SSLContext;
import java.util.Arrays;

/**
 * Provides a small runtime-oriented view of security/TLS related notes around
 * Java 9.
 * <p>
 * The focus here is not on performing a full TLS handshake, but on showing the
 * default SSL context and available protocol information exposed by the JDK.
 */
public class SecurityTlsInfoDemo {

    /**
     * Prints default protocol and a few supported TLS protocol names.
     *
     * @param args command-line arguments (not used)
     * @throws Exception if the default SSL context cannot be loaded
     */
    public static void main(String[] args) throws Exception {
        SSLContext context = SSLContext.getDefault();

        System.out.println("=== Security/TLS Notes (Java 9) ===");
        System.out.println("Default protocol: " + context.getProtocol());
        System.out.println("Supported protocols count: " + context.getSupportedSSLParameters().getProtocols().length);
        System.out.println("Sample protocols: " + Arrays.toString(Arrays.copyOf(
                context.getSupportedSSLParameters().getProtocols(),
                Math.min(3, context.getSupportedSSLParameters().getProtocols().length))));
    }
}

