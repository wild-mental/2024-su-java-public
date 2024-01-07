package interfaceimplement;

public interface InterfaceSample2 {
    default void absMethodInInterface2() {
        System.out.println("인터페이스 2에 있는 디폴트 메서드입니다.");
    }

    abstract void absMethodInInterface2(int a);
}
