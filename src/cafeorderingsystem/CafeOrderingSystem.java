package cafeorderingsystem;

import cafeorderingsystem.enums.*;
import java.util.Scanner;

public class CafeOrderingSystem {
    private static Order order;
    private static Beverage[] beverages;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        order = new Order();  // order의 라이프 사이클이 case 2 로 들어가면 좋겠어요
        beverages = getBeverages();  // 데이터 초기화 부분을 별도로 분리한 점 매우 좋음!

        while (true) {
            displayMenu();

            System.out.print("옵션 중 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBeverageMenu();
                    break;
                case 2:
                    placeOrder(scanner);
                    break;
                case 3:
                    displayStock();
                    break;
                case 4:
                    exitSystem();
                    return;
                default:
                    System.out.println("유효하지 않은 옵션입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== 카페 주문 시스템 =====");
        System.out.println("1. 메뉴 조회");
        System.out.println("2. 주문");
        System.out.println("3. 재고 조회");
        System.out.println("4. 종료");
    }

    private static void displayBeverageMenu() {
        System.out.println("\n===== 음료 메뉴 =====");

        for (Beverage beverage : beverages) {
            System.out.println(beverage.toString());
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.println("\n===== 주문 =====");

        while (true) {
            System.out.print("주문할 음료를 선택하세요 (done으로 주문 종료): ");
            String selectedBeverage = scanner.next();

            if (selectedBeverage.equalsIgnoreCase("done")) {
                break;
            }

            Beverage beverage = getBeverageByName(selectedBeverage);

            if (beverage != null) {
                processOrderForBeverage(scanner, beverage);
            } else {
                System.out.println("잘못된 음료명입니다.");
            }
        }
        order.completeOrder();
    }

    private static void processOrderForBeverage(Scanner scanner, Beverage beverage) {
        System.out.print("수량을 입력하세요: ");
        int quantity = scanner.nextInt();

        Size size = getSizeFromUser(scanner, beverage);
        Temperature temperature = getTemperatureFromUser(scanner, beverage);

        order.addBeverage(beverage, quantity, size, temperature);
    }

    private static Size getSizeFromUser(Scanner scanner, Beverage beverage) {
        if (beverage.isFrappe()) {
            return Size.MEDIUM;
        } else if (beverage.isTea()) {
            System.out.print("사이즈를 선택하세요 (medium, large): ");
            String sizeString = scanner.next().toUpperCase();
            return Size.valueOf(sizeString);
        }

        System.out.print("사이즈를 선택하세요 (small, medium, large): ");
        String sizeString = scanner.next().toUpperCase();
        return Size.valueOf(sizeString);
    }

    private static Temperature getTemperatureFromUser(Scanner scanner, Beverage beverage) {
        if (beverage.isFrappe()) {
            return Temperature.COLD;
        } else if (beverage.isTea()) {
            return Temperature.HOT;
        }

        System.out.print("둘 중 선택하세요 (hot, cold): ");
        String temperatureString = scanner.next().toUpperCase();
        return Temperature.valueOf(temperatureString);
    }

    private static void displayStock() {
        System.out.println("\n===== 재고 조회 =====");
        for (Beverage beverage : beverages) {
            System.out.println(beverage.stockToString());
        }
    }

    private static void exitSystem() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    // 음료 객체들
    private static Beverage[] getBeverages() {
        Beverage americano = new Coffee("아메리카노", 0.9, 1.4, 2.7, 10);
        Beverage cafeLatte = new Coffee("카페라떼", 1.9, 2.4, 4.5, 9);
        Beverage vanillaLatte = new Coffee("바닐라라떼", 2.2, 2.8, 4.9, 8);
        Beverage cafeMocha = new Coffee("카페모카", 2.4, 2.9, 5.0, 7);

        Beverage chocolateLatte = new NonCoffee("초코라떼", 2.0, 2.6, 4.5, 6);
        Beverage sweetPotatolLatte = new NonCoffee("고구마라떼", 2.3, 3.1, 4.5, 5);

        Beverage citronTea = new Tea("유자차", 2.3, 3.5, 4);
        Beverage chamomileTea = new Tea("캐모마일차", 3.7, 4.5, 3);

        Beverage javaChipFrappe = new Frappe("자바칩프라페", 4.4, 2);
        Beverage cookiesAndCreamFrappe = new Frappe("쿠앤크프라페", 4.2, 1);

        return new Beverage[]{americano, cafeLatte, vanillaLatte, cafeMocha,
                chocolateLatte, sweetPotatolLatte,
                citronTea, chamomileTea,
                javaChipFrappe, cookiesAndCreamFrappe};
    }

    // 음료명으로 음료 객체를 찾는 메서드
    private static Beverage getBeverageByName(String name) {
        for (Beverage beverage : beverages) {
            if (beverage.getName().equalsIgnoreCase(name)) {
                return beverage;
            }
        }
        return null;
    }
}