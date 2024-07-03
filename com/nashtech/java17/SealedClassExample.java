package nashtech.java17;/*
  Sealed classes (Shape): Shape is an interface that explicitly lists the classes (Circle and Rectangle) that can implement it (permits Circle, Rectangle).
  This restricts the inheritance hierarchy and provides more control over class extensions.
*/

import java.util.logging.Logger;

// Sealed classes example
class SealedClassExample {
    private static final Logger logger = Logger.getLogger(SealedClassExample.class.getName());

    // Pattern matching for switch example
    public static void main(String[] args) {
        Shape shape = new Circle(5); // Example with Circle

        double area = switch (shape) {
            case Circle c -> c.area();
            case Rectangle r -> r.area();
            default -> throw new IllegalArgumentException("Unexpected value: " + shape);
        };

        logger.info("Area: " + area);
    }

    sealed interface Shape permits Circle, Rectangle {
        double area();
    }

    final static class Circle implements Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    final class Rectangle implements Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    }
}
