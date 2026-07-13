package com.learning.concepts.features.java15.demo;

/**
 * Runs all Java 15 feature demo classes in sequence.
 */
public class Java15AllFeaturesRunner {

    /**
     * Invokes all Java 15 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        TextBlocksStandardDemo15.main(args);
        SealedClassesPreviewInfoDemo15.main(args);
        HiddenClassesInfoDemo15.main(args);
        RecordsSecondPreviewInfoDemo15.main(args);
        PatternMatchingSecondPreviewInfoDemo15.main(args);
        ZgcProductionInfoDemo15.main(args);
        NashornRemovalInfoDemo15.main(args);
        RmiActivationRemovalInfoDemo15.main(args);
        DatagramSocketReimplementationInfoDemo15.main(args);
        EdDSAInfoDemo15.main(args);
    }
}

