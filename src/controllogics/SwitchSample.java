package controllogics;

public class SwitchSample {
    public static void main(String[] args) {
        int a = 10;
        switch(a){
            case 10:
                System.out.println(a);
                break;
            case 20:
                return;
        }
    }
}
