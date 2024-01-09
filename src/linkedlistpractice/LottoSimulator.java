package linkedlistpractice;

import java.util.*;

public class LottoSimulator {

    // 두 개의 HashSet이 동일한지를 비교하는 메서드
    private static <T> boolean areHashSetsEqual(Set<T> set1, Set<T> set2) {
//        if (set1.size() != set2.size()) {
//            return false; // 크기가 다르면 동일하지 않음
//        }
        // containsAll은 모든 요소가 포함되어 있으면 true를 반환
        return set1.containsAll(set2);
    }
    public static void main(String[] args) {
//        List<Integer> lottoWinnerNumbers = new ArrayList<>(6);
        Set<Integer> lottoWinnerNumberSet = new HashSet<>(6);
        Random numberPicker = new Random();

        // 반복 리스트가 6개 채워질 때까지
        int singleNumberPicked;
//        while (lottoWinnerNumbers.size() < 6) {
        while (lottoWinnerNumberSet.size() < 6) {
            singleNumberPicked = numberPicker.nextInt(1, 46);
            // 기존 리스트에 해당 항목이 없는 경우에만 추가
            if (!lottoWinnerNumberSet.contains(singleNumberPicked)) {
                lottoWinnerNumberSet.add(singleNumberPicked);
            }
        }
//        Collections.sort(lottoWinnerNumbers);

        // 딩첨 될 때까지 뽑기
//        List<Integer> lottoTryNumbers = new ArrayList<>(6);
        Set<Integer> lottoTryNumberSet = new HashSet<>(6);
        int tryCount=0;
//        while (!lottoWinnerNumbers.equals(lottoTryNumbers)) {
        do {
            lottoTryNumberSet.clear();
            tryCount++;
            // 복권 번호 완성
            while (lottoTryNumberSet.size() < 6) {
                singleNumberPicked = numberPicker.nextInt(1, 46);
                // 기존 리스트에 해당 항목이 없는 경우에만 추가
                if (!lottoTryNumberSet.contains(singleNumberPicked)) {
                    lottoTryNumberSet.add(singleNumberPicked);
                }
            }
//            Collections.sort(lottoTryNumbers);
//            System.out.println(lottoWinnerNumbers);
//            System.out.println(lottoTryNumbers);
            System.out.println("-----------------------");
        } while (!areHashSetsEqual(lottoWinnerNumberSet, lottoTryNumberSet));

        System.out.println(tryCount+"회차 로또를 구매하여 로또에 당첨되었습니다!");
        System.out.println(lottoWinnerNumberSet);
        System.out.println(lottoTryNumberSet);
    }
}
