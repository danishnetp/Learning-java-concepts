package com.learning.concepts.features.java8.demo.inter_and_abstract;

/**
 * Compares static methods in interfaces and abstract classes.
 * <p>
 * Both can define static methods in Java 8+, but interface static methods are not inherited
 * by implementers, while class static methods follow class-member rules and may be hidden
 * by subclasses.
 */
public class StaticMethodBehaviorExample {

    interface NameFormatter {
        static String normalize(String input) {
            return input == null ? "" : input.trim().toUpperCase();
        }
    }

    static abstract class AbstractNameFormatter {
        static String normalize(String input) {
            return input == null ? "" : input.trim().toLowerCase();
        }
    }

    static class ChildFormatter extends AbstractNameFormatter {
        static String normalize(String input) {
            return input == null ? "" : "child:" + input.trim();
        }
    }

    /**
     * Prints output from each static method to highlight call-site differences.
     */
    public static void demonstrate() {
        String raw = "  Java8  ";

        // Interface static methods are called with InterfaceName.methodName.
        String fromInterface = NameFormatter.normalize(raw);

        // Abstract class static methods can be called on class types and hidden in subclasses.
        String fromAbstractBase = AbstractNameFormatter.normalize(raw);
        String fromAbstractChild = ChildFormatter.normalize(raw);

        System.out.println("[Static] Interface static method = " + fromInterface);
        System.out.println("[Static] Abstract base static method = " + fromAbstractBase);
        System.out.println("[Static] Abstract child static method = " + fromAbstractChild);
    }
}

