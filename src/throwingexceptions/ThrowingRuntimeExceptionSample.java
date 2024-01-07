package throwingexceptions;

public class ThrowingRuntimeExceptionSample {
        public static void main(String[] args) {
            try {
                // Uncomment the line corresponding to the exception you want to throw

                // Example 1: ArithmeticException
                // int result = 10 / 0;

                // Example 2: NullPointerException
                // String str = null;
                // System.out.println(str.length());

                // Example 3: ArrayIndexOutOfBoundsException
                // int[] arr = new int[5];
                // System.out.println(arr[10]);

                // Example 4: ClassCastException
                // Object obj = "Hello";
                // Integer number = (Integer) obj;

                // Example 5: NumberFormatException
                // String notANumber = "abc";
                // int num = Integer.parseInt(notANumber);

                // Example 6: IllegalArgumentException
                // validateAge(-1);

                // Example 7: UnsupportedOperationException
                // throwUnsupportedOperationException();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void validateAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("나이는 음수가 될 수 없음.");
            }
            System.out.println("Valid age: " + age);
        }

        private static void throwUnsupportedOperationException() {
            // 규칙에 벗어난 경우 상황에 맞는 메시지 전달
            throw new UnsupportedOperationException("이 연산은 OOO 규칙에 위배됨.");
        }
    }