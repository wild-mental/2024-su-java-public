package stringandlogging;

import java.util.Arrays;

public class StringSplit {
    public static void main(String[] args) {
        String input = "apple,orange,banana";
        String[] parts = input.split(",");
        System.out.println(Arrays.toString(parts));
    }
}
