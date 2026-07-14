package com.learning.concepts.java_features.java12.demo;

/**
 * Runs all Java 12 feature demo classes in sequence.
 * <p>
 * Use this as a single entry point to see output from every Java 12 sample
 * without launching each class individually.
 */
public class Java12AllFeaturesRunner {

    /**
     * Invokes every Java 12 feature demo class in order.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        SwitchExpressionDemo.main(args);
        StringIndentDemo.main(args);
        StringTransformDemo.main(args);
        CollectorsTeeingDemo.main(args);
        FilesMismatchDemo.main(args);
        NumberFormatCompactDemo.main(args);
        GarbageCollectorImprovementsDemo.main(args);
    }
}

