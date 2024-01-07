package sameorequal;

public class SameOrEqualSample {
    public static void main(String[] args) {
        String a = "a";
        if (a == "a") {  // hashCode() - 이후 객체의 동일성 여부를 비교하기 위한 용도로 사용하게 된다.
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
