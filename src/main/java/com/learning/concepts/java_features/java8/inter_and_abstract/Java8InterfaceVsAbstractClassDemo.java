package com.learning.concepts.java_features.java8.inter_and_abstract;

/**
 * Entry-point runner that executes all Java 8 interface-vs-abstract-class examples.
 * <p>
 * Keep this class simple so learners can run one main method and inspect output in order.
 */
public class Java8InterfaceVsAbstractClassDemo {

    /**
     * Runs all demonstration classes in a fixed sequence.
     */
    public static void main(String[] args) {
        System.out.println("=== Java 8 Interface vs Abstract Class Examples ===");

        InterfaceFieldsExample.demonstrate();
        AbstractConstructorExample.demonstrate();
        StaticMethodBehaviorExample.demonstrate();
        DefaultMethodVsConcreteMethodExample.demonstrate();
        InitializerBlockExample.demonstrate();
        FunctionalInterfaceLambdaExample.demonstrate();
        ObjectMethodOverrideExample.demonstrate();
    }
}

