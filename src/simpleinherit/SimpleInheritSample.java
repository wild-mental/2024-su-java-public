package simpleinherit;

public class SimpleInheritSample {
    public static void main(String[] args) {
//        Parent a = new Parent();
//        a.hello("java");
//        a.hello("");
//        a.hello(null);
//
//        Child b = new Child();
//        b.hello("java");
//        b.hello("");
//        b.hello(null);

        // 자식 타입의 객체가 부모 타입의 변수에 할당되는 것을 허용한다.
        Parent childObjToParent = new Child();
        childObjToParent.hello("everyone");

        // Child parentObjToChild = new Parent();  // 금지!!

    }
}
