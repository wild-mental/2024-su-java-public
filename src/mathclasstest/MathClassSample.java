package mathclasstest;

import java.util.Random;

public class MathClassSample {
    public static void main(String[] args) {
//        double result1 = Math.rint(10.5); // Rounds to 10.0
//        double result2 = Math.rint(11.5); // Rounds to 12.0
//        double result3 = Math.rint(10.2); // Rounds to 10.0
//        double result4 = Math.rint(10.8); // Rounds to 11.0
//
//        System.out.println("Result 1: " + result1);
//        System.out.println("Result 2: " + result2);
//        System.out.println("Result 3: " + result3);
//        System.out.println("Result 4: " + result4);

//        float result1 = Math.round(10.5f); // Rounds to 11
//        float result2 = Math.round(11.5f); // Rounds to 12
//        float result3 = Math.round(10.2f); // Rounds to 10
//        float result4 = Math.round(10.8f); // Rounds to 11
//
//        System.out.println("Result 1: " + result1);
//        System.out.println("Result 2: " + result2);
//        System.out.println("Result 3: " + result3);
//        System.out.println("Result 4: " + result4);

//        double minValue = Math.min(10.5, 8.0);
//        double maxValue = Math.max(10.5, 8.0);
//        System.out.println("Minimum: " + minValue);
//        System.out.println("Maximum: " + maxValue);

        double randomValue = Math.random();
        System.out.println("Random Value: " + randomValue);

        Random rnd = new Random();
        int lottoSingleNumber = rnd.nextInt(1, 46);
        System.out.println(lottoSingleNumber);
    }
}
