package simpleinherit;

public class Parent {
    @Deprecated
    public void hello (String target) {
        if (target==null || target.isEmpty()) {
            System.out.println("hello nobody!");
        } else {
            System.out.println("hello "+ target + "!");
        }
    }
}
