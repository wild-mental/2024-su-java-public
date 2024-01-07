package interfaceimplement;

public interface InterfaceSample {
    abstract void absMethod();
    abstract void absMethod(int a);
    abstract void absMethod(int a, int b);

    default void  absMethod(int a, int b, int c) {
        System.out.println("이것은 디폴트 동작입니다! 구현하지 않아도 됩니다!");
    }
}
