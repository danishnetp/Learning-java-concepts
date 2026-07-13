package com.learning.concepts.features.java17.demo;

/**
 * Runs all Java 17 feature demo classes in sequence.
 */
public class Java17AllFeaturesRunner {

    /**
     * Invokes all Java 17 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        SealedClassesStandardDemo17.main(args);
        PatternMatchingSwitchPreviewInfoDemo17.main(args);
        RandomGeneratorApiDemo17.main(args);
        ForeignFunctionMemoryInfoDemo17.main(args);
        StrongEncapsulationInfoDemo17.main(args);
        StrictFloatingPointInfoDemo17.main(args);
        DeserializationFilterInfoDemo17.main(args);
        RmiActivationRemovalInfoDemo17.main(args);
        MetalPipelineInfoDemo17.main(args);
    }
}

