package cafeorderingsystem;

import cafeorderingsystem.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // 한번 들어간 주문은 변경 불가한 케이스를 구현하기 위해
    // record 타입의 OrderedBeverage 클래스와 final 필드를 아주 적절하게 사용했네요 :)
    private final List<OrderedBeverage> orderedBeverages;

    public Order() {
        this.orderedBeverages = new ArrayList<>();
    }

    // 주문에 음료 추가
    public void addBeverage(Beverage beverage, int quantity, Size size, Temperature temperature) {
        int availableStock = beverage.getStock();
        int totalQuantity = quantity;

        for (OrderedBeverage orderedBeverage : orderedBeverages) {
            if (orderedBeverage.beverage().equals(beverage)) {
                totalQuantity += orderedBeverage.quantity();
            }
        }

        if (totalQuantity > availableStock) {
            System.out.println(beverage.getName() + "의 재고가 부족합니다. 현재 재고: " + availableStock);
            return;
        }

        orderedBeverages.add(new OrderedBeverage(beverage, quantity, size, temperature));
    }

    // 주문 총액 계산
    public double calculateTotalPrice() {
        double total = 0;
        for (OrderedBeverage orderedBeverage : orderedBeverages) {
            total += orderedBeverage.calculatePrice();
        }
        return total;
    }

    // 주문 완료 및 재고 감소
    public void completeOrder() {
        System.out.println("\n주문 내역:");

        for (OrderedBeverage orderedBeverage : orderedBeverages) {
            System.out.println(orderedBeverage.beverage().getName() +
                    " " + orderedBeverage.quantity() +
                    "잔 " + orderedBeverage.size().toString().toLowerCase() +
                    " " + orderedBeverage.temperature().toString().toLowerCase());

            orderedBeverage.beverage().decreaseStock(orderedBeverage.quantity());
        }
        System.out.println("주문이 완료되었습니다. 총액: " + calculateTotalPrice() + "(천) 원");
        orderedBeverages.clear();
    }
}