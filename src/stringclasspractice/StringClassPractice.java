package stringclasspractice;

import java.util.Arrays;
import java.util.List;

public class StringClassPractice {
    public static void main(String[] args) {
//        String testString = "1234567";
//        System.out.println(testString.hashCode());
        List<String> testStrings = Arrays.asList(
                "AAAAAAAB",
                "AAAAAABA",
                "AAAAAAABAAAAAAABAAAAAAABAAAAAAA",
                new String("AAAAAAABAAAAAAABAAAAAAABAAAAAAA")
        );
        for (String a: testStrings) {
            System.out.println(a.hashCode());
        }
    }
}
