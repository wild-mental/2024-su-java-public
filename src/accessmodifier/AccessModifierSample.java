package accessmodifier;

import accessmodifier.a.*;
import accessmodifier.b.B;
import accessmodifier.b.C;

public class AccessModifierSample {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
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