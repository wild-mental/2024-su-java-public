package simpleinherit;

public class Parent {
//    @Deprecated
    public void hello(String target) {
        // 매개변수를 검증합니다. (validation)
        if (target==null || target.isEmpty()) {
            System.out.println("hello nobody!");
        } else {
            System.out.println("hello "+ target + "!");
        }
    }
}
