package interfaceimplement;

public class ImplementationClass extends AbstractClass1 implements InterfaceSample, InterfaceSample2{

    @Override
    public void absMethod() {
        System.out.println("absMethod() overridden in ImplClass");
    }

    @Override
    public void absMethod(int a) {
    }

    @Override
    public void absMethod(int a, int b) {
    }

    @Override
    public void absMethodInInterface2(int a) {
        System.out.println("absMethodInInterface2() overridden in ImplClass");
    }

    @Override
    void absMethodInAbsClass() {

    }
}
