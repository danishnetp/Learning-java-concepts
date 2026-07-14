package com.learning.concepts.java_features.java19.demo;

/**
 * Runs all Java 19 feature demo classes in sequence.
 */
public class Java19AllFeaturesRunner {

    /**
     * Invokes all Java 19 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     */
    public static void main(String[] args) {
        PatternMatchingSwitchPreviewInfoDemo19.main(args);
        RecordPatternsPreviewInfoDemo19.main(args);
        VirtualThreadsPreviewInfoDemo19.main(args);
        StructuredConcurrencyIncubatorInfoDemo19.main(args);
        ScopedValuesIncubatorInfoDemo19.main(args);
        ForeignFunctionMemoryPreviewInfoDemo19.main(args);
        VectorApiFourthIncubatorInfoDemo19.main(args);
        LinuxRiscVPortInfoDemo19.main(args);
    }
}

