package travelandimmigration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelSampleMain {
    public static void main(String[] args) {
        Nation korea = new Nation("대한민국", "한국");
        Scanner scanner = new Scanner(System.in);

        // static 하게 호출해서, 세계정부가 모든 것을 다루고 있었음
        Nation.ImmigrationOffice.processEntry(korea, scanner);
        Nation.ImmigrationOffice.processImmigrantRequest(scanner);
        Nation.EntryAndExitOffice.processEntry(korea, scanner);

        // instance 의 멤버로 출입국/이민 관리국 객체를 두어서 한국 정부 소속의 처리 가능해짐
        Nation koreaWithOffices = new Nation("행정국가 대한민국", "한국", true);
        Nation.EntryAndExitOffice koreanEEOffice = koreaWithOffices.getEntryAndExitOffice();
        Nation.ImmigrationOffice koreanImmigrationOffice =koreaWithOffices.getImmigrationOffice();

        scanner.close();
    }
}