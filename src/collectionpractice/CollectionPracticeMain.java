package collectionpractice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionPracticeMain {
    public static void main(String[] args) {
        Map<String, Integer> myIntMap= new HashMap<>(7);

        myIntMap.put(null, 1);
        myIntMap.put("", 1);
        System.out.println(myIntMap);

        myIntMap.put("A", 1);
        myIntMap.put("A", 1);
        myIntMap.put("A", 1);
        System.out.println(myIntMap);

        myIntMap.put("A", 1);
        myIntMap.put("B", 1);
        myIntMap.put("C", 1);
        myIntMap.put("D", 1);
        myIntMap.put("E", 1);
        System.out.println(myIntMap);

        System.out.println(myIntMap.keySet() instanceof Set);
        System.out.println(myIntMap.values() instanceof Collection<Integer>);
        System.out.println(myIntMap.values());
        System.out.println(myIntMap.entrySet() instanceof Set<Map.Entry<String, Integer>>);
    }
}
