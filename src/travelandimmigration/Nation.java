package travelandimmigration;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class Nation implements ITravelProcessActions {
    private final String name;
    private final String nationality;
    private EntryAndExitOffice entryAndExitOffice;
    private ImmigrationOffice immigrationOffice;

    public Nation(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Nation(String name, String nationality, boolean offices) {
        this.name = name;
        this.nationality = nationality;
        if (offices) {
            this.entryAndExitOffice = new EntryAndExitOffice(this);
            this.immigrationOffice = new ImmigrationOffice(this);
        }
    }

    private boolean hasCriminalRecord(Person immigrant) {
        return immigrant.hasCriminalRecord();
    }

    @Override
    public void processGroupEntry(List<Person> travelers) {
        System.out.println(getName() + "에 대한 입국 처리를 시작합니다.");
        travelers.forEach(traveler -> System.out.println("  - " + traveler.getName()));
    }

    @Override
    public void processImmigrantRequest(List<Person> immigrants) {
        System.out.println(getName() + "에서 이민자 신청을 처리합니다.");

        for (Person immigrant : immigrants) {
            System.out.println("  - " + immigrant.getName() + " (" + immigrant.getNationality() + ")");
            if (hasCriminalRecord(immigrant)) {
                System.out.println("    - 범죄 기록이 있는 이민자에게 이민을 거부합니다.");
            } else {
                System.out.println("    - 범죄 기록이 없는 이민자의 이민을 허가합니다.");
            }
        }
    }

    public String toString() {
        return "Nation{" +
                "name='" + name + '\'' +
                "nationality" + nationality + '\'' +
                '}';

    }

    // 출입국 관리청
    public static class EntryAndExitOffice {

        Nation officeNationality;

        EntryAndExitOffice(Nation officeNationality) {
            this.officeNationality = officeNationality;
        }

        public static void processEntry(Nation nation, Scanner scanner) {
            System.out.println("여행자 입국 처리를 시작합니다. (종료하려면 'exit'을 입력하세요)");

            while (true) {
                System.out.print("여행자 이름을 입력하세요: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                while (true) {
                    System.out.println("여행자 국적을 입력하세요: ");
                    String nationality = scanner.nextLine();

                    if (nationality.equalsIgnoreCase("미국") || nationality.equalsIgnoreCase("America")) {
                        System.out.println("미국 국민에게 입국을 거부합니다.");
                        break;
                    }

                    Person traveler = null;
                    while (true) {
                        System.out.print("여행자의 RRN을 입력하세요: ");
                        String rrnInput = scanner.nextLine();

                        if (rrnInput.trim().isEmpty()) {
                            System.out.println("신원이 명확하지 않은 사람에게는 입국을 거부합니다.");
                            continue;
                        }

                        if (rrnInput.matches("\\d+")) {
                            traveler = new Person(name, rrnInput, "", nationality, false, false);
                            Person.incrementPeopleCount();
                            break;
                        } else {
                            System.out.println("잘못된 형식입니다. 숫자로만 입력하세요.");
                        }
                    }

                    System.out.print("여행자 사용 언어를 입력하세요: ");
                    String language = scanner.nextLine();

                    if (language.equalsIgnoreCase("일본어") || language.equalsIgnoreCase("Japanese") || language.equalsIgnoreCase("japanese")) {
                        System.out.println("일본어를 쓰는 여행자에게 입국을 거부합니다.");
                        break;
                    } else {
                        nation.processGroupEntry(List.of(traveler));
                        System.out.println("입국 처리가 완료되었습니다");
                        break;
                    }
                }
            }
        }

        public void processGroupEntry(List<Person> travelers) {
            System.out.println(officeNationality.getName() + "에 대한 입국 처리를 시작합니다.");
            travelers.forEach(traveler -> System.out.println("  - " + traveler.getName()));
        }

        public void processEntry(Scanner scanner) {
            System.out.println("여행자 입국 처리를 시작합니다. (종료하려면 'exit'을 입력하세요)");

            while (true) {
                System.out.print("여행자 이름을 입력하세요: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                while (true) {
                    System.out.println("여행자 국적을 입력하세요: ");
                    String nationality = scanner.nextLine();

                    if (nationality.equalsIgnoreCase("미국") || nationality.equalsIgnoreCase("America")) {
                        System.out.println("미국 국민에게 입국을 거부합니다.");
                        break;
                    }

                    Person traveler = null;
                    while (true) {
                        System.out.print("여행자의 RRN을 입력하세요: ");
                        String rrnInput = scanner.nextLine();

                        if (rrnInput.trim().isEmpty()) {
                            System.out.println("신원이 명확하지 않은 사람에게는 입국을 거부합니다.");
                            continue;
                        }

                        if (rrnInput.matches("\\d+")) {
                            traveler = new Person(name, rrnInput, "", nationality, false, false);
                            Person.incrementPeopleCount();
                            break;
                        } else {
                            System.out.println("잘못된 형식입니다. 숫자로만 입력하세요.");
                        }
                    }

                    System.out.print("여행자 사용 언어를 입력하세요: ");
                    String language = scanner.nextLine();

                    if (language.equalsIgnoreCase("일본어") || language.equalsIgnoreCase("Japanese") || language.equalsIgnoreCase("japanese")) {
                        System.out.println("일본어를 쓰는 여행자에게 입국을 거부합니다.");
                        break;
                    } else {
//                        officeNationality.processGroupEntry(List.of(traveler));
                        // 국가 객체가 아니라, 출입국 관리국에 들어와야 하는 기능임
                        this.processGroupEntry(List.of(traveler));
                        System.out.println("입국 처리가 완료되었습니다");
                        break;
                    }
                }
            }
        }
    }

    // 이민 관리청
    public static class ImmigrationOffice {
        Nation officeNationality;

        ImmigrationOffice(Nation officeNationality) {
            this.officeNationality = officeNationality;
        }
        public static void processEntry(Nation nation, Scanner scanner) {

            System.out.println("입국 처리를 시작합니다. (종료하려면 'exit'을 입력하세요)");
        }
        public static void processImmigrantRequest(Scanner scanner) {
            System.out.println("이민자 신청을 처리합니다. (종료하려면 'exit'을 입력하세요)");

            List<Person> immigrants = new ArrayList<Person>();

            while (true) {
                System.out.print("이민자 이름을 입력하세요: ");
                String immigrantName = scanner.nextLine();

                if (immigrantName.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("이민자 국적을 입력하세요: ");
                String immigrantNationality = scanner.nextLine();

                if (immigrantNationality.equalsIgnoreCase("미국") || immigrantNationality.equalsIgnoreCase("America")) {
                    System.out.println("미국 국민 이민자에게 이민을 거부합니다.");
                    continue;
                }

                boolean hasCriminalRecord;
                while (true) {
                    System.out.print("이민자가 범죄 기록이 있습니까? (y/n): ");
                    String hasCriminalRecordInput = scanner.nextLine().trim();

                    if (hasCriminalRecordInput.equalsIgnoreCase("y")) {
                        System.out.println("범죄 기록이 있는 이민자에게 이민을 허용하지 않습니다");
                        break;
                    } else if (hasCriminalRecordInput.equalsIgnoreCase("n")) {
                        System.out.println("이민이 처리되었습니다.");
                        Person immigrant = new Person(immigrantName, "0", "", immigrantNationality, false, false);
                        immigrants.add(immigrant);
                        Person.incrementPeopleCount();
                        break;
                    } else {
                        System.out.println("올바른 값을 입력하세요 (y/n).");
                    }
                }
            }

            System.out.println("이민자 처리가 완료되었습니다");
            System.out.println("총 처리 인원 수는 " + Person.getPeopleCount() + "명입니다. 프로세스를 종료합니다.");
        }
    }
}