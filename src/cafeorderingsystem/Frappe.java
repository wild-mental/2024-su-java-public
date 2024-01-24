package cafeorderingsystem;

import cafeorderingsystem.enums.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class Frappe extends Beverage {
    private double mediumPrice;

    public Frappe(String name, double mediumPrice, int stock) {
        super(name, stock);
        this.mediumPrice = mediumPrice;
    }

    @Override
    public double getPrice(Size size) {
        if (Objects.requireNonNull(size) == Size.MEDIUM) {
            return mediumPrice;
        }
        throw new IllegalArgumentException("지원하지 않는 사이즈입니다.");
    }

    @Override
    public boolean isFrappe() {
        return true;
    }

    @Override
    public boolean isTea() {
        return false;
    }
    @Override
    public String toString() {
        return super.getName() + "- medium " + mediumPrice;
    }
}