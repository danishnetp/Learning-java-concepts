package com.learning.concepts.java_features.java16.demo;

/**
 * Demonstrates sealed classes and interfaces in Java 16.
 * Sealed types control inheritance by restricting which classes/interfaces
 * can extend or implement them.
 */
public class SealedClassesPreviewInfoDemo16 {

    // ===== Sealed Class Example =====
    sealed abstract static class Shape permits Circle, Rectangle {
        abstract double area();
    }

    static final class Circle extends Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return "Circle(r=" + radius + ", area=" + area() + ")";
        }
    }

    static final class Rectangle extends Shape {
        private double width, height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }

        @Override
        public String toString() {
            return "Rectangle(w=" + width + ", h=" + height + ", area=" + area() + ")";
        }
    }

    // ===== Sealed Interface Example =====
    sealed interface Vehicle permits Car, Bike {
        void drive();
    }

    static final class Car implements Vehicle {
        private String model;

        Car(String model) {
            this.model = model;
        }

        @Override
        public void drive() {
            System.out.println("Car: " + model + " driving on 4 wheels.");
        }
    }

    static final class Bike implements Vehicle {
        private String brand;

        Bike(String brand) {
            this.brand = brand;
        }

        @Override
        public void drive() {
            System.out.println("Bike: " + brand + " driving on 2 wheels.");
        }
    }

    /**
     * Demonstrates sealed classes and interfaces with concrete examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes & Interfaces (Java 16) ===");
        System.out.println();

        System.out.println("--- Sealed Class Example ---");
        Shape circle = new Circle(5.0);
        Shape rect = new Rectangle(4.0, 6.0);
        System.out.println(circle);
        System.out.println(rect);
        System.out.println();

        System.out.println("--- Sealed Interface Example ---");
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Yamaha");
        car.drive();
        bike.drive();
        System.out.println();

        System.out.println("Purpose: Restricted inheritance via 'permits' clause.");
        System.out.println("Permitted subclasses must be: final, sealed, or non-sealed.");
    }
}

