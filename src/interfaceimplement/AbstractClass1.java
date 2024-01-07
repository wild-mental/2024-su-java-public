package interfaceimplement;

abstract public class AbstractClass1 implements InterfaceSample, InterfaceSample2{
    abstract void absMethodInAbsClass();

    void absMethodInAbsClass(int a) {

    }

    public static void main(String[] args) {
//        AbstractClass1 prohibitedInstantiation = new AbstractClass1();
    }
}
