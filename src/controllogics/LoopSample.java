package controllogics;

public class LoopSample {
    public static void main(String[] args) {
//        int a = 10;
//        while(a > 0) {
//            System.out.println(a);
//            a-=1;
//        }
//
//        a = 10;
//        do {
//            System.out.println(a);
//            a-=1;
//        } while(a > 0);
//
//        for(int k = 10; k > 0; k-=1) {
////            반복할 실행문;
//        }

        int[] arrayA = {1, 2, 3, 4, 5};

        outerFor:
        for (int aa: arrayA) {
            innerFor:
            for (int innerA: arrayA) {
                if(aa == 3) {
                    continue outerFor;
                }
                System.out.println(aa);
            }
        }
    }
}
