package solidprinciple.interfacesegregation;

public class IspViolationSampleMain {
    public static void main(String[] args) {
        Shape cube = new Cube(10, 10, 10);
        System.out.println(cube.calculateArea()); // 600
        System.out.println(cube.calculateVolume()); // 1_000

        Shape rect = new Rectangle(10, 20);
        System.out.println(rect.calculateArea()); // 200
        System.out.println(rect.calculateVolume()); // 예외 발생!
    }
}

interface Shape {
    double calculateArea();
    double calculateVolume();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculateVolume() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("사각형은 부피 계산이 불가능합니다!");
    }
}

class Cube implements Shape {
    private double width;
    private double height;
    private double depth;

    public Cube(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double calculateArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public double calculateVolume() {
        return width * height * depth;
    }
}