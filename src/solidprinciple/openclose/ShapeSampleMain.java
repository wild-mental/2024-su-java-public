package solidprinciple.openclose;

public class ShapeSampleMain {
    public static void main(String[] args) {
        // Usage example here
    }
}

class AreaCalculator {
    public double calculateArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

interface IAreaMeasurable {
    double calculateArea();
}

abstract class Shape implements IAreaMeasurable{

}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements IAreaMeasurable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}
