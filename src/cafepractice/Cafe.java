package cafepractice;

public class Cafe {
    public static CafeDrinkMenu makeDrink(CafeDrinkMenu menu) throws InterruptedException {
        System.out.println("주문하신 " + menu.getName() + "를 제작중입니다.");
        Thread.sleep(2000);
        System.out.println(menu.getName() + "(이)가 제작 완료되었습니다!");
        return menu;
    }
}