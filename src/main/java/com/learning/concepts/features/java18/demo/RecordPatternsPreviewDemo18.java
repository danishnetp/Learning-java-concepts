package com.learning.concepts.features.java18.demo;

/**
 * Demonstrates record patterns (first preview in Java 18).
 * Record patterns enable destructuring of records in pattern matching.
 */
public class RecordPatternsPreviewDemo18 {

    record Point(int x, int y) {}

    record Circle(Point center, int radius) {}

    /**
     * Uses record patterns to destructure nested records.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(5, 10), 7);

        System.out.println("=== Record Patterns (Preview in Java 18) ===");
        System.out.println("Preview syntax requires --enable-preview.");
        System.out.println("This demo shows equivalent compile-safe extraction:");

        // Compile-safe fallback: use record accessors directly.
        Point center = circle.center();
        int x = center.x();
        int y = center.y();
        int r = circle.radius();
        System.out.println("Circle at point (" + x + ", " + y + ") with radius " + r);

        // Demonstrate with array of points
        Point[] points = {
                new Point(0, 0),
                new Point(3, 4),
                new Point(1, 1)
        };

        System.out.println("\nPoints:");
        for (Point point : points) {
            System.out.println("  Point(" + point.x() + ", " + point.y() + ")");
        }

        System.out.println();
        System.out.println("Preview example:");
        System.out.println("  if (obj instanceof Point(int px, int py)) {");
        System.out.println("      ...");
        System.out.println("  }");
    }
}

