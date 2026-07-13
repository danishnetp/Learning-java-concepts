package com.learning.concepts.features.java16.demo;

/**
 * Runs all Java 16 feature demo classes in sequence.
 */
public class Java16AllFeaturesRunner {

    /**
     * Invokes all Java 16 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        RecordsStandardDemo16.main(args);
        PatternMatchingInstanceofStandardDemo16.main(args);
        SealedClassesPreviewInfoDemo16.main(args);
        VectorApiInfoDemo16.main(args);
        ForeignLinkerApiInfoDemo16.main(args);
        UnixDomainSocketInfoDemo16.main(args);
        ElasticMetaspaceInfoDemo16.main(args);
        StrongEncapsulationInfoDemo16.main(args);
        JpackageStandardInfoDemo16.main(args);
        RemovedAotGraalInfoDemo16.main(args);
    }
}

