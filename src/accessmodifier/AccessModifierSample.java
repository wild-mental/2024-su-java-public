package accessmodifier;

import accessmodifier.a.*;
import accessmodifier.b.B;
import accessmodifier.b.C;

public class AccessModifierSample {
    public static void main(String[] args) {
        System.out.println("-----------   Direct Call of A methods    -----------");
//        A.printPrivateStrA();
//        A.printProtectedStrA();
//        A.printPackagePrivateStrA();
        A.printPublicStrA();
        System.out.println("----------- Call A.main() -----------");
        A.main(new String[0]);
        System.out.println("-------------------------------------");

        System.out.println("---------- in the package -----------");
        System.out.println("----------- Call B.main() -----------");
        accessmodifier.a.B.main(new String[0]);
        System.out.println("----------- Call C.main() -----------");
        accessmodifier.a.C.main(new String[0]);
        System.out.println("-------------------------------------");

        System.out.println("---------- out of package -----------");
        System.out.println("----------- Call B.main() -----------");
        B.main(new String[0]);
        System.out.println("----------- Call C.main() -----------");
        C.main(new String[0]);
        System.out.println("-------------------------------------");
    }
}