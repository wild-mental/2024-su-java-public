package cafeorderingsystem;

import cafeorderingsystem.enums.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tea extends Beverage {
    private double mediumPrice;
    private double largePrice;

    public Tea(String name, double mediumPrice, double largePrice, int stock) {
        super(name, stock);
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    @Override
    public double getPrice(Size size) {
        return switch (size) {
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
            default -> throw new IllegalArgumentException("지원하지 않는 사이즈입니다.");
        };
    }

    @Override
    public boolean isFrappe() {
        return false;
    }

    @Override
    public boolean isTea() {
        return true;
    }

    @Override
    public String toString() {
        return super.getName() + "- medium " + mediumPrice +
                ", large " + largePrice;
    }
}