package stringclasspractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSample {
    public static void main(String[] args) {
        Deque<Integer> intDeque = new ArrayDeque<>(20);
        for (int i=0; i<10; i++) {
            intDeque.add(i);
            intDeque.addLast(i);
        }
        System.out.println(intDeque + " <- use end");

        for (int i=0; i<20; i++) {
            System.out.println(intDeque.removeLast());
        }
    }
}
