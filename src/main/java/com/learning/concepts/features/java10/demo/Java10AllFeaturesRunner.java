package com.learning.concepts.features.java10.demo;

/**
 * Runs all Java 10 feature demo classes in sequence.
 * <p>
 * Use this as a single entry point to see the output of every Java 10
 * sample without launching each class individually.
 */
public class Java10AllFeaturesRunner {

    /**
     * Invokes every Java 10 feature demo class in order.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        LocalVariableTypeInferenceDemo.main(args);
        UnmodifiableCollectionCopyDemo.main(args);
        CollectorsToUnmodifiableDemo.main(args);
        OptionalOrElseThrowDemo.main(args);
        ParallelG1GcInfoDemo.main(args);
        AppCdsInfoDemo.main(args);
        ThreadLocalHandshakeInfoDemo.main(args);
        TimeBasedVersioningInfoDemo.main(args);
        RootCertificatesInfoDemo.main(args);
    }
}

