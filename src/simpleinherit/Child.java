package simpleinherit;

public class Child extends Parent {
    @Override
    @SuppressWarnings("deprecation")
    public void hello(String target) {
        if (target==null || target.isEmpty()) {
            super.hello(target);
        } else {
            System.out.println("hello "+target+" from child!");
        }
    }
}
