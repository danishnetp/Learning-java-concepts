package com.learning.concepts.java_features.java11.demo;

/**
 * Runs all Java 11 feature demo classes in sequence.
 * <p>
 * Use this as a single entry point to see output from every Java 11 sample
 * without launching each class individually.
 */
public class Java11AllFeaturesRunner {

    /**
     * Invokes every Java 11 feature demo class in order.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        LambdaVarSyntaxDemo.main(args);
        StringEnhancementsDemo.main(args);
        FilesApiEnhancementsDemo.main(args);
        CollectionToArrayDemo.main(args);
        PredicateNotDemo.main(args);
        HttpClientFinalizedDemo.main(args);
        SingleFileSourceCodeInfoDemo.main(args);
        GarbageCollectorInfoDemo.main(args);
        NestBasedAccessControlInfoDemo.main(args);
    }
}

