package com.learning.concepts.features.java14.demo;

/**
 * Runs all Java 14 feature demo classes in sequence.
 */
public class Java14AllFeaturesRunner {

    /**
     * Invokes all Java 14 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        SwitchExpressionsDemo14.main(args);
        HelpfulNpeDemo14.main(args);
        PatternMatchingInstanceofDemo14.main(args);
        TextBlocksPreviewInfoDemo14.main(args);
        RecordsPreviewInfoDemo14.main(args);
        JpackageToolInfoDemo14.main(args);
        G1NumaInfoDemo14.main(args);
        JfrEventStreamingInfoDemo14.main(args);
        RemovedFeaturesInfoDemo14.main(args);
    }
}

