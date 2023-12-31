package abstractandinterface;

public class MyClass extends MyAbstractClass implements IMyClass{
    @Override
    public void callableA() {
        System.out.println("Method IMyClass.callableA() must have been overridden");
    }

    @Override
    public void callableB() {
        System.out.println("Method IMyClass.callableB() must have been overridden");
    }

    @Override
    public void callableC() {
        System.out.println("Method MyAbstractClass.callableC() must have been overridden");
    }

//    @Override
//    public void callableD() {
//        super.callableD();
//        System.out.println("method callableD overridden in MyClass is called");
//    }
}
