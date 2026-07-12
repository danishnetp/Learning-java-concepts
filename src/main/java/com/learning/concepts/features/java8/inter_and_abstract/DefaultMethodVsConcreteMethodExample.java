package com.learning.concepts.features.java8.inter_and_abstract;

/**
 * Demonstrates two ways to provide reusable method implementations:
 * interface default methods and abstract-class concrete methods.
 */
public class DefaultMethodVsConcreteMethodExample {

    interface InterfaceGreeter {
        default String greet(String name) {
            return "Hello from interface default, " + name;
        }
    }

    static abstract class AbstractGreeter {
        public String greet(String name) {
            return "Hello from abstract class concrete method, " + name;
        }
    }

    static class InterfaceGreeterImpl implements InterfaceGreeter {
        // Inherits default implementation.
    }

    static class AbstractGreeterImpl extends AbstractGreeter {
        // Inherits concrete implementation.
    }

    /**
     * Prints both inherited outputs to compare default vs concrete inheritance.
     */
    public static void demonstrate() {
        InterfaceGreeter interfaceGreeter = new InterfaceGreeterImpl();
        AbstractGreeter abstractGreeter = new AbstractGreeterImpl();

        System.out.println("[Default/Concrete] " + interfaceGreeter.greet("Alice"));
        System.out.println("[Default/Concrete] " + abstractGreeter.greet("Bob"));
    }
}

