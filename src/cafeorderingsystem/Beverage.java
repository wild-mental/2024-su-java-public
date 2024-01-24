package cafeorderingsystem;

import cafeorderingsystem.enums.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Beverage {
    private String name;
    private int stock;

    public Beverage(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public abstract double getPrice(Size size);

    public void decreaseStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            System.out.println(name + "은(는) 품절입니다.");
        }
    }

    // Beverage 아래의 두 추상 메서드는 자식 타입 중에서도 일부 자식 클래스가 부모에 영향을 주고 있어서, extends 구조에 역행
    public abstract boolean isFrappe();
    public abstract boolean isTea();

    public String stockToString() {
        return name + "의 재고: " + stock;
    }
}