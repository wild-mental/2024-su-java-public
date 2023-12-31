package accessmodifier.a;

public class A {
    private static void printPrivateStrA() {
        System.out.println("privateStrA");
    }
    static void printPackagePrivateStrA() {
        /* package-private */
        System.out.println("packagePrivateStrA");
    }
    protected static void printProtectedStrA() {
        System.out.println("protectedStrA");
    }
    public static void printPublicStrA() {
        System.out.println("publicStrA");
    }

    /* 1. private 멤버 접근 가능한 유일한 위치 */
    public static void main(String[] args) {
        A.printPrivateStrA();
        A.printPackagePrivateStrA();
        A.printProtectedStrA();
        A.printPublicStrA();
    }
}

