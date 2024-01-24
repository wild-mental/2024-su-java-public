package sealedclassandinstanceof;

public sealed class Shape permits Circle, Square {
    private String shapeName;

    public Shape() {
    }

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }
}

final class Circle extends Shape {
    private String circleName;

    public Circle() {

    }

    public Circle(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleName() {
        return circleName;
    }
}
final class Square extends Shape {
    private String squareName;

    public Square() {

    }

    public Square(String squareName) {
        this.squareName = squareName;
    }

    public String getSquareName() {
        return squareName;
    }
}

// Sealed 클래스의 효과!
// 상속 계층 구조를 특정 범위까지만 허용하는 효과를 가져온다.
//final class Cube extends sealedclassandinstanceof.Shape { }

