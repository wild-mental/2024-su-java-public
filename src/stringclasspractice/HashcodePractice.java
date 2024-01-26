package stringclasspractice;

import java.util.HashMap;
import java.util.Map;

public class HashcodePractice {
    public static void main(String[] args) {
        Map<Integer, Object> objectMap = new HashMap<>(); // {해시코드 : 객체} 형태의 Map 자료형
        int j = 1;

        // int형 범위(21억번) 돌림
        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object newObj = new Object(); // 객체 생성
            int hashCode = newObj.hashCode(); // 해시코드 얻기

            // Map에 해당 해시 코드가 존재하는지 확인 (만일 있다면 출력)
            Object objInMap = objectMap.get(hashCode);
            if (objInMap != null) {
                System.out.println((i - Integer.MIN_VALUE + 1L) + "번째 루프");
                System.out.println("새롭게 만든 객체 해시코드 : " + newObj.hashCode());
                System.out.println("기존에 있는 객체 해시코드 : " + objInMap.hashCode());
                System.out.println("해시코드가 같아도 objInMap == newObj 는 : " + (objInMap.equals(newObj))); // 해시코드가 같아도 객체의 주솟값은 원래 다르니 false 출력
                System.out.println("");

                if (j >= 10) return; // 4번만 출력
                j++;
            } else {
                objectMap.put(hashCode, newObj); // Map에 해시코드와 객체 등록
            }
        }
    }
}
