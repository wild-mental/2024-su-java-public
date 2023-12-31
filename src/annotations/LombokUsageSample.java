package annotations;

import lombok.Data;

@Data
public class LombokUsageSample {
    private boolean employed = false;
    private int age = 20;

    public static void main(String[] args) {
        LombokUsageSample sul = new LombokUsageSample();
        System.out.println(sul.getAge());
        System.out.println(sul.isEmployed());
        sul.setAge(30);
        sul.setEmployed(true);
        System.out.println(sul.getAge());
        System.out.println(sul.isEmployed());
    }

    /* lombok makes these with just simple annotations
    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isEmployed() {
        return employed;
    }
    */
}
