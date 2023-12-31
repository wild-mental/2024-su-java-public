package stringandlogging;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StringControlSample {
    public static void main(String[] args) {
        convert("한국어중국어영어");
        stringValueCheck(null);
        indexCheck();
    }

    public static void convert(String inputString) {
        try {
            byte[] array = inputString.getBytes("EUC-KR");
            System.out.println(array.length);
            for (byte data:array){
                System.out.print("data="+data+" ");
            }
            System.out.println();
            String arrayString = Arrays.toString(array);
            System.out.println(arrayString);
            String korean2 = new String(array, "EUC-KR");
            System.out.println(korean2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stringValueCheck(String a) { System.out.println(a); }

    public static void indexCheck () {
//        String alps = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789012345678901234567890123456789";
        System.out.println(nums.indexOf("1", 20));
        System.out.println(nums.lastIndexOf("0", 30));
    }
}