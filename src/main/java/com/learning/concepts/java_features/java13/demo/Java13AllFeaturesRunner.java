package com.learning.concepts.java_features.java13.demo;

/**
 * Runs all Java 13 feature demo classes in sequence.
 */
public class Java13AllFeaturesRunner {

    /**
     * Invokes all Java 13 demos from one entry point.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        TextBlocksDemo.main(args);
        SwitchExpressionYieldDemo.main(args);
        FileSystemsPathDemo.main(args);
        DynamicCdsInfoDemo.main(args);
        ZgcUncommitInfoDemo.main(args);
        LegacySocketReimplementationInfoDemo.main(args);
        JpackageInfoDemo.main(args);
        UnicodeSupportInfoDemo.main(args);
    }
}

