package enumwithcreator;

import java.util.Arrays;

public class EnumUseSample {
    public static void main(String[] args) {
        EnumWithCreator enumEntry1Value = EnumWithCreator.ENUM_ENTRY_1;
        EnumWithCreator[] enumArray = EnumWithCreator.values();
        System.out.println(Arrays.toString(enumArray));
    }
}
