package com.learning.concepts.java_features.java9.demo;

/**
 * Runs all Java 9 sample classes in sequence.
 * <p>
 * This runner is useful when you want a single entry point to review the
 * output of all feature demos without launching each class individually.
 */
public class Java9AllFeaturesRunner {

    /**
     * Invokes every Java 9 feature demo class one after another.
     *
     * @param args command-line arguments passed through to each demo
     * @throws Exception if any delegated demo throws an exception
     */
    public static void main(String[] args) throws Exception {
        ModuleSystemInfoDemo.main(args);
        InterfacePrivateMethodDemo.main(args);
        CollectionFactoryMethodsDemo.main(args);
        StreamEnhancementsDemo.main(args);
        OptionalEnhancementsDemo.main(args);
        TryWithResourcesEnhancementDemo.main(args);
        DiamondWithAnonymousClassDemo.main(args);
        EnhancedDeprecatedDemo.main(args);
        JShellInfoDemo.main(args);
        HttpClientFeatureDemo.main(args);
        ProcessApiEnhancementsDemo.main(args);
        ReactiveStreamsFlowDemo.main(args);
        StackWalkerDemo.main(args);
        VarHandleDemo.main(args);
        JvmAndGcInfoDemo.main(args);
        MultiReleaseJarInfoDemo.main(args);
        JlinkJmodInfoDemo.main(args);
        AotCompilationInfoDemo.main(args);
        JavadocHtml5InfoDemo.main(args);
        SecurityTlsInfoDemo.main(args);
    }
}

