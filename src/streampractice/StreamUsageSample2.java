package streampractice;

import java.util.Arrays;
import java.util.List;

public class StreamUsageSample2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t"
        );
//        System.out.println("-------single process-------");
//        list.forEach(System.out::print);
        System.out.println("\n-------parallel process-------");
        list.parallelStream().forEach(System.out::print);
    }
}
