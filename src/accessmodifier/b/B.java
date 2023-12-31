package accessmodifier.b;

import accessmodifier.a.A;

public class B extends A{
    public static void main(String[] args){
//        A.printPrivateStrA();
//        A.printPackagePrivateStrA();
        A.printProtectedStrA();
        A.printPublicStrA();
    }
}
