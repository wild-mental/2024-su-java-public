package cafepractice;

import java.util.Scanner;
public class Customer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CafeMenuOrder cafeOrder = new CafeMenuOrder();
        cafeOrder.orderChoiceAnswer(sc);
    }
}