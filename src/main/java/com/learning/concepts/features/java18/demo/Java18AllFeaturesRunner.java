package com.learning.concepts.features.java18.demo;

/**
 * Runs all Java 18 feature demo classes in sequence.
 */
public class Java18AllFeaturesRunner {

    /**
     * Invokes all Java 18 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        PatternMatchingSwitchPreviewDemo18.main(args);
        RecordPatternsPreviewDemo18.main(args);
        TextBlocksStandardDemo18.main(args);
        VirtualThreadsPreviewDemo18.main(args);
        StructuredConcurrencyInfoDemo18.main(args);
        ForeignFunctionMemoryInfoDemo18.main(args);
        DeprecatedEnhancementsDemo18.main(args);
        Utf8CharsetDemo18.main(args);
        SimpleWebServerInfoDemo18.main(args);
        CodeReflectionInfoDemo18.main(args);
    }
}

