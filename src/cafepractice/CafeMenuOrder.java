package cafepractice;
import java.util.Map;
import java.util.Scanner;

public class CafeMenuOrder {
    private boolean OrderChoice = false;
    private CafeDrinkMenu selectMenu;
    private boolean pickUp;
    private boolean storeUse;
    public void orderChoiceAnswer(Scanner sc){
        boolean choice = false;
        while(!choice) {
            if (!OrderChoice) {
                System.out.print("주문을 하시겠습니까?: ");
                String orderanswer = sc.next();
                if (orderanswer.equals("네")) {
                    processOrder(sc);
                    choice = true;
                }else{
                    break;
                }
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }

    public void processOrder(Scanner sc) {
        //계산 후 주문이 들어가게끔
        System.out.println("------------메뉴판------------");
        for (Map.Entry<String, CafeDrinkMenu> entry : CafeDrinkMenu.menuname.entrySet()) {
            CafeDrinkMenu menu = entry.getValue();
            System.out.println("메뉴: " + menu.getName() + "\t가격: " + menu.getPrice());
        }
        boolean menuAnswer = false;
        while(!menuAnswer) {
            System.out.print("메뉴를 골라주세요: ");
            String answer = sc.next();
            for (Map.Entry<String, CafeDrinkMenu> entry : CafeDrinkMenu.menuname.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(answer)) {
                    selectMenu = entry.getValue();
                    break;
                }
            }
            if (selectMenu != null) {
                System.out.println("고르신 메뉴: " + selectMenu.getName() + "\n가격: " + selectMenu.getPrice());
                System.out.print("계산하시겠습니까?(네/아니오): ");
                answer = sc.next();
                if (answer.equals("네")) {
                    OrderChoice = true;
                    try {
                        Cafe.makeDrink(selectMenu);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("테이크아웃, 매장이용 중에 선택해주세요.: ");
                    String useAnswer = sc.next();
                    if (useAnswer.equals("테이크아웃")) {
                        pickUp = true;
                    } else if (useAnswer.equals("매장이용")) {
                        storeUse = true;
                    }
                    useItDrink();
                    break;
                } else {
                    System.out.println("메뉴를 더 골라주세요.");
                }
            } else {
                System.out.println("없는 메뉴입니다. 다시 골라주세요.");
            }
        }
    }
    public void useItDrink(){
        if(pickUp){
            System.out.println(selectMenu.getName() + "을(를) 테이크아웃 하였습니다.");
        }
        if(storeUse){
            System.out.println("매장이용합니다.");
        }
    }

}