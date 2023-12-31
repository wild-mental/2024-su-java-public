package simpleinherit;

public class SimpleInheritSample {
    public static void main(String[] args) {
        Parent a = new Parent();
        a.hello("java");
        a.hello("");
        a.hello(null);
        Child b = new Child();
        b.hello("java");
        b.hello("");
        b.hello(null);
    }
}
