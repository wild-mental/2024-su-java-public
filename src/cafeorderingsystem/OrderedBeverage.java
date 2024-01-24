package cafeorderingsystem;

import cafeorderingsystem.enums.*;

public record OrderedBeverage(Beverage beverage, int quantity, Size size, Temperature temperature) {

    public double calculatePrice() {
        return beverage.getPrice(size) * quantity;
    }
}