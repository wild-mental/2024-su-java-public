package cafepractice;

import java.util.HashMap;
import java.util.Map;

public class CafeDrinkMenu {
    public static final Map<String, CafeDrinkMenu> menuname = new HashMap<>();
    static{
        menuname.put("아메리카노", new CafeDrinkMenu("아메리카노", 2000));
        menuname.put("카페라떼", new CafeDrinkMenu("카페라뗴", 3000));
        menuname.put("아이스티", new CafeDrinkMenu("아이스티", 3500));
        menuname.put("밀크티", new CafeDrinkMenu("밀크티", 2500));
        menuname.put("에이드", new CafeDrinkMenu("에이드", 4000));
    }
    private String name;
    private int price;

    public CafeDrinkMenu(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}