package enumwithcreator;

public enum EnumWithCreator {
    ENUM_ENTRY_1(1100),
    ENUM_ENTRY_2(1200),
    ENUM_ENTRY_3(1300),
    ENUM_ENTRY_4(1400),
    ENUM_ENTRY_5(1500);

    private final int memberInt;

    EnumWithCreator(int memberInt) {
        this.memberInt = memberInt;
    }

    public int getMemberInt() {
        return this.memberInt;
    }
}
