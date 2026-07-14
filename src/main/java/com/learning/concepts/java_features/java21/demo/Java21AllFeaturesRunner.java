package com.learning.concepts.java_features.java21.demo;

/**
 * Runs all Java 21 feature demo classes in sequence.
 */
public class Java21AllFeaturesRunner {

    /**
     * Invokes all Java 21 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     */
    public static void main(String[] args) {
        VirtualThreadsStandardInfoDemo21.main(args);
        PatternMatchingSwitchStandardInfoDemo21.main(args);
        RecordPatternsStandardInfoDemo21.main(args);
        SequencedCollectionsStandardInfoDemo21.main(args);
        GenerationalZgcStandardInfoDemo21.main(args);
        KemApiStandardInfoDemo21.main(args);
        StringTemplatesPreviewInfoDemo21.main(args);
        UnnamedPatternsVariablesPreviewInfoDemo21.main(args);
        UnnamedClassesInstanceMainPreviewInfoDemo21.main(args);
        ScopedValuesPreviewInfoDemo21.main(args);
        ForeignFunctionMemoryThirdPreviewInfoDemo21.main(args);
        VectorApiSixthIncubatorInfoDemo21.main(args);
        DynamicAgentLoadingWarningInfoDemo21.main(args);
        Windows32BitX86DeprecationInfoDemo21.main(args);
    }
}

