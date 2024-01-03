package sameorequal;

public class SameOrEqualSample {
    public static void main(String[] args) {
        String a = "a";
        if (a == "a") {
            System.out.println("same!");
        }

        if (a == new String("a")){
            System.out.println(a);
        }

        if (a.equals(new String("a"))) {
            System.out.println("equal!");
        }
    }
}
