package com.learning.concepts.features.java17.demo;

/**
 * Demonstrates sealed classes/interfaces as a standard feature in Java 17.
 */
public class SealedClassesStandardDemo17 {

    sealed interface Shape permits Circle, Rectangle {
        double area();
    }

    static final class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static final class Rectangle implements Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    /**
     * Creates sealed hierarchy instances and prints calculated areas.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Shape circle = new Circle(2.0);
        Shape rectangle = new Rectangle(4.0, 3.0);

        System.out.println("=== Sealed Classes (Standard in Java 17) ===");
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
    }
}

