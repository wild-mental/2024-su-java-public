package reflectionpractice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // ArrayList 객체 생성
            ArrayList<String> arrayList = new ArrayList<>();

            // private 멤버인 'elementData' 필드 얻기
            Field elementDataField = ArrayList.class.getDeclaredField("elementData");

            // 'elementData' 필드에 접근 권한 설정
            elementDataField.setAccessible(true);
            /*
            Exception in thread "main" java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.lang.Object[] java.util.ArrayList.elementData accessible: module java.base does not "opens java.util" to module sample_java_basic_2024_
            at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:354)
            at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
            at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:178)
            at java.base/java.lang.reflect.Field.setAccessible(Field.java:172)
            at sample_java_basic_2024_/reflectionpractice.ReflectionExample.main(ReflectionExample.java:17)
            */

            // ArrayList 객체에 값을 추가하여 elementData 배열 초기화
            arrayList.add("Example");

            // 'elementData' 필드의 값을 읽기 (Object[] 형태로 반환)
            Object[] elementDataValue = (Object[]) elementDataField.get(arrayList);

            // 결과 출력
            System.out.println("ArrayList elementData: " + Arrays.toString(elementDataValue));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
