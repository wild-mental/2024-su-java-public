package primitiveandreference;

import java.math.BigDecimal;

public class FloatPointNumbers {
    public static void main(String[] args) {
        float myFloat = 10.123f;  // 32bit 소수점 7자리
        double myDouble = 10.123123123d;  // 64bit 소수점 15자리
        // 자릿수를 나타내는 값, 실제 값
        // 정밀도, precision

        BigDecimal myFloatDecimal = BigDecimal.valueOf(myFloat);
        BigDecimal myDoubleDecimal = BigDecimal.valueOf(myDouble);

        // 언더 플로우 : 자릿수 (이진수 비트가 부족해서 발생하는 정밀도 손실)

    }
}
