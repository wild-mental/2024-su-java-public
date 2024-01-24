package sealedclassandinstanceof;

public class InstanceOfSample {
    public static void main(String[] args) {
        Shape myShape1 = new Shape("simple shape");
        Shape myShape2 = new Circle("simple circle");
        Shape myShape3 = new Square("simple square");

        Shape[] shapes = { myShape1, myShape2, myShape3 };
//        if (myShape1 instanceof Shape) {
//            System.out.println("Shape 입니다!");
//        }
//
//        if (myShape2 instanceof Circle) {
//            System.out.println("Circle 입니다!");
//        } else if (myShape2 instanceof Shape) {
//            System.out.println("Shape 입니다!2");
//        }
//
//        if (myShape3 instanceof Circle) {
//            System.out.println("Circle 입니다!");
//        } else if (myShape3 instanceof Square) {
//            System.out.println("Square 입니다!");
//        } else if (myShape3 instanceof Shape) {
//            System.out.println("Shape 입니다!2");
//        }

        for (Shape anyShape: shapes){
            if (anyShape instanceof Circle myCircleShape) {
                System.out.println("Circle 입니다!");
//            Circle myCircleShape3 = (Circle)myShape3;
                myCircleShape.getCircleName();
            } else if (anyShape instanceof Square mySquareShape) {
                System.out.println("Square 입니다!");
                mySquareShape.getSquareName();
            } else if (anyShape instanceof Shape) {
                System.out.println("Shape 입니다!");
                anyShape.getShapeName();
            }
        }
    }
}
