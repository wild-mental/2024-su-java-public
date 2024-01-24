package streampractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUsageSample {
    public static void main(String[] args) {
        int[] values = { -1, -2, -3, -4, -5, 0, 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(values);
        int naturalNumCnt = (int)intStream.filter(x -> x > 0).count();
        System.out.println(naturalNumCnt);

        List<Integer> numbers = Arrays.asList( -10, -20, -30, -40, -50, 0, 10, 20, 30, 40, 50 );
        Stream<Integer> integerStream = numbers.stream();
        List<Integer> negativeNumList = integerStream.filter(x -> x < 0).collect(Collectors.toList());
        System.out.println(negativeNumList);

        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("One", 1);
        dataMap.put("Two", 2);
        dataMap.put("Three", 3);
        dataMap.put("Four", 4);
        dataMap.put("Five", 5);
        Map<Integer, String> reversedMap = dataMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        System.out.println(reversedMap);
        reversedMap.entrySet().forEach(System.out::println);
    }
}
