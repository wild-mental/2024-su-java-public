package travelandimmigration;

import lombok.Getter;

@Getter
public class Person {
    private final String name;
    private final String language;
    private final String nationality;
    private final String RRN;
    private final boolean isUnderThreat;
    private final boolean hasCriminalRecord;

    @Getter
    private static int peopleCount = 0;

    public Person(String name, String RRN, String language, String nationality,
                  boolean isUnderThreat, boolean hasCriminalRecord) {
        this.name = name;
        this.language = language;
        this.nationality = nationality;
        this.RRN = RRN;
        this.isUnderThreat = isUnderThreat;
        this.hasCriminalRecord = hasCriminalRecord;
    }

    public static void incrementPeopleCount() {
        peopleCount++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", nationality='" + nationality + '\'' +
                ", RRN='" + RRN + '\'' +
                ", isUnderThreat=" + isUnderThreat +
                ", hasCriminalRecord=" + hasCriminalRecord +
                '}';
    }

    public boolean hasCriminalRecord() {
        return hasCriminalRecord;
    }
}