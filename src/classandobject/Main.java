package classandobject;

import classandobject.objclass.Dog;

public class Main {
    public static void main(String[] args) {
        // 객체 생성
        Dog myDog1 = new Dog("Buddy1", 3);
        Dog myDog2 = new Dog("Buddy2", 4);
        Dog myDog3 = new Dog("Buddy3", 5);
        Dog myDog4 = new Dog("Buddy4", 6);

        // 객체 사용
        myDog1.bark();
        myDog2.bark();
        myDog3.bark();
        myDog4.bark();

        {
            int a = 10;
            int b = a + 10;
        }

        boolean isForLegAnimal = Dog.fourLegs;
//        int dogName = Dog.name;

    }
}