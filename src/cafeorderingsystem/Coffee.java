package cafeorderingsystem;

import cafeorderingsystem.enums.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Coffee extends Beverage {
    private double smallPrice;
    private double mediumPrice;
    private double largePrice;

    public Coffee(String name, double smallPrice, double mediumPrice, double largePrice, int stock) {
        super(name, stock);
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    @Override
    public double getPrice(Size size) {
        return switch (size) {
            case SMALL -> smallPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
    }

    @Override
    public boolean isFrappe() {
        return false;
    }

    @Override
    public boolean isTea() {
        return false;
    }

    @Override
    public String toString() {
        return super.getName() + "- small " + smallPrice +
                ", medium " + mediumPrice +
                ", large " + largePrice;
    }
}