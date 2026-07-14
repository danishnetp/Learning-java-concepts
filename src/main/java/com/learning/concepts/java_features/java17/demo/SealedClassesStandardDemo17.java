package com.learning.concepts.java_features.java17.demo;

/**
 * Demonstrates sealed classes and sealed interfaces as standard features in Java 17.
 * Sealed types control inheritance/implementation by restricting which classes
 * or interfaces can extend or implement them.
 */
public class SealedClassesStandardDemo17 {

    // ===== Sealed Class Example =====
    sealed abstract static class Animal permits Dog, Cat {
        abstract String sound();

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + " makes: " + sound();
        }
    }

    static final class Dog extends Animal {
        @Override
        String sound() {
            return "Woof!";
        }
    }

    static final class Cat extends Animal {
        @Override
        String sound() {
            return "Meow!";
        }
    }

    // ===== Sealed Interface Example =====
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

        @Override
        public String toString() {
            return "Circle(r=" + radius + ", area=" + String.format("%.2f", area()) + ")";
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

        @Override
        public String toString() {
            return "Rectangle(w=" + width + ", h=" + height + ", area=" + area() + ")";
        }
    }

    /**
     * Creates sealed class and interface hierarchy instances and displays properties.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes & Interfaces (Standard in Java 17) ===");
        System.out.println();

        System.out.println("--- Sealed Class Hierarchy ---");
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.println(dog);
        System.out.println(cat);
        System.out.println();

        System.out.println("--- Sealed Interface Hierarchy ---");
        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(4.0, 5.0);
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println();

        System.out.println("Sealed types restrict inheritance/implementation via 'permits' clause.");
        System.out.println("Permitted subclasses must be: final, sealed, or non-sealed.");
    }
}

