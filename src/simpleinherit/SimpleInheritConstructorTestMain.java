package simpleinherit;

public class SimpleInheritConstructorTestMain {
    public static void main(String[] args) {
        Child2 ch2 = new Child2();
    }
}

class Parent2 {
    Parent2() {
        this("a");
        System.out.println("Parent2() is completed");
    };
    Parent2(String a) {
        System.out.println("Parent2(a) is completed");
    }
}

class Child2 extends Parent2 {
    Child2() {
        this("a");
        System.out.println("Child2() is completed");
    };
    Child2(String a) {
        System.out.println("Child2(a) is completed");
    }
}
