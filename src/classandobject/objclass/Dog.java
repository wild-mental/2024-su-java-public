package classandobject.objclass;

public class Dog {
    public static boolean fourLegs = true;

    // 멤버 변수
    public String name;
    public int age;
    public int ageSpecial;

    // 생성자
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, int ageSpecial) {
        this.name = name;
        this.age = age;
        this.ageSpecial = ageSpecial;
    }

    public Dog(int ageSpecial, String name,  int age) {
        this.name = name;
        this.age = age;
        this.ageSpecial = ageSpecial;
    }

    // 메서드
    public void bark() {
        System.out.println("Woof! My name is " + name + " and I'm " + age + " years old.");
    }

    public void bark(int a) {
        System.out.println("Woof! My name is " + name + " and I'm " + age + " years old.");
    }
}
