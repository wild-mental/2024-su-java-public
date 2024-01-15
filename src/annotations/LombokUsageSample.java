package annotations;

import lombok.Data;
import lombok.NonNull;

@Data
public class LombokUsageSample {
    // 기본적인 필수값 필드 선언 방법은 final 키워드 사용
//    private final int age;
//    private final boolean employed;

    // final 키워드가 없으면 필수값 필드 생성자에서 제외됨
    private int age = 20;
    private boolean employed = false;

    @NonNull  // 필수값 필드 생성자는 NonNull 어노테이션이 적용된 필드를 감지하여 필수값으로 간주
    private String name;

    /* lombok 을 사용하면 아래와 같은 메서드를 수동 생성할 필요가 없어짐
    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isEmployed() {
        return employed;
    }
    */

    public static void main(String[] args) {
        LombokUsageSample sul = new LombokUsageSample(null);
        System.out.println(sul.getAge());
        sul.setAge(30);
        System.out.println(sul.getAge());

        System.out.println(sul.isEmployed());
        sul.setEmployed(true);
        System.out.println(sul.isEmployed());

        // @NonNull 어노테이션으로 자동 검사됨
        sul.setName(null);

//        LombokUsageSample a = new LombokUsageSample(20, false);
//        System.out.println(a);
    }
}