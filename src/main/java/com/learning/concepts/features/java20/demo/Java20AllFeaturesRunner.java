package com.learning.concepts.features.java20.demo;

/**
 * Runs all Java 20 feature demo classes in sequence.
 */
public class Java20AllFeaturesRunner {

    /**
     * Invokes all Java 20 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     */
    public static void main(String[] args) {
        PatternMatchingSwitchFourthPreviewInfoDemo20.main(args);
        RecordPatternsSecondPreviewInfoDemo20.main(args);
        VirtualThreadsSecondPreviewInfoDemo20.main(args);
        StructuredConcurrencySecondIncubatorInfoDemo20.main(args);
        ScopedValuesIncubatorInfoDemo20.main(args);
        ForeignFunctionMemorySecondPreviewInfoDemo20.main(args);
        VectorApiFifthIncubatorInfoDemo20.main(args);
        CoreRuntimeUpdatesInfoDemo20.main(args);
    }
}

