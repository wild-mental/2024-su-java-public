package shallowanddeep;

public class CopyTypeSample {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = a;
        int[] c = a.clone();

        a[4] = 99;  // {1, 2, 3, 4, 99};
        System.out.printf("5th int in b is : %d \n" ,b[4]);
        System.out.printf("5th int in c is : %d" ,c[4]);
    }
}
