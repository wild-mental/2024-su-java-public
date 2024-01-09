package collectionpractice;

import java.util.ArrayList;

public class ArraySizeControlMain {
    public static void main(String[] args) {
        // ArrayList 생성
        ArrayList<String> arrayList = new ArrayList<>(100);

        // ArrayList에 요소 추가
        arrayList.add("요소1");
        arrayList.add("요소2");

        // ArrayList의 현재 크기 확인
        System.out.println("현재 ArrayList의 크기: " + arrayList.size());

        // ArrayList의 배열 크기를 미리 확보
        arrayList.ensureCapacity(1000);

        // ArrayList의 현재 크기 다시 확인
        System.out.println("변경된 ArrayList의 크기: " + arrayList.size());
    }
}
