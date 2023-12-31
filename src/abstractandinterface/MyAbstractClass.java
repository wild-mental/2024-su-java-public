package abstractandinterface;

public abstract class MyAbstractClass {
    public abstract void callableC();
//    public abstract void callableD();  // JDK17 이후로 중복 금지
    public void callableD() {
        System.out.println("normal method callableD in MyAbstractClass is called");
    }
}
