package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ConcurrencyBasicSample {
    static int sharedVar = 0;  // 스레드 간 공유된 static 메모리 영역의 변수
    static List<Integer> integerArrayList = new ArrayList<>();  // Thread unsafe 메서드 제공..
    static List<Integer> integerVector = new Vector<>();  // Thread safe 메서드 제공!

    static Runnable runnable = () -> {
        for (int i = 0; i < 10; i++) {
            sharedVar++;
            integerArrayList.add(sharedVar);
            integerVector.add(sharedVar);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    static class MethodSyncedRunnable implements Runnable {
        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                sharedVar++;
                integerArrayList.add(sharedVar);
                integerVector.add(sharedVar);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static synchronized void syncedRun() {
        for (int i = 0; i < 10; i++) {
            sharedVar++;
            integerArrayList.add(sharedVar);
            integerVector.add(sharedVar);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class BlockSyncedRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ConcurrencyBasicSample.class) {
                    sharedVar++;
                    integerArrayList.add(sharedVar);
                    integerVector.add(sharedVar);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static Runnable syncedRunnable = () -> {
        for (int i = 0; i < 10; i++) {
            synchronized (ConcurrencyBasicSample.class) {
                sharedVar++;
                integerArrayList.add(sharedVar);
            }
            integerVector.add(sharedVar);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static void main(String[] args) {
        // ========== 틀린 사례 ==========
        // Not Synced lambda (wrong case 1)
        // 1) ArrayList 동시 접근 중 일부 접근이 실패함
        // 2) ArrayList 에 대한 작업 순서가 보장 안됨
        // 3) Vector 동시 접근은 Sync 를 통해 순차 처리 되지만, 공유 변수 동시 접근은 순차 처리가 안됨
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        // Synced Runnable (wrong case 2)
        // 싱크 된 것으로 착각할 수 있지만, 스레드 별로 다른 Runnable 객체가 생성 및 전달됨 -> 각 객체가 Sync 기준이 됨
//        Thread t1 = new Thread(new MethodSyncedRunnable());
//        Thread t2 = new Thread(new MethodSyncedRunnable());

        // ========== 맞는 사례 ==========
        // Synced Runnable (right case 1 - okay) : 메서드 단위 객체 싱크
        // 각 스레드 생성 시 같은 Runnable 객체를 할당 -> Sync 기준이 하나의 객체로 통일됨
        // 하지만 메서드 전체를 싱크 하므로 성능상 비효율 발생함
//        Runnable syncTogether = new MethodSyncedRunnable();
//        Thread t1 = new Thread(syncTogether);
//        Thread t2 = new Thread(syncTogether);
        // Synced Method (right case 2 - good) : 메서드 단위 메서드 싱크
        // 객체가 아닌 Synced 메서드 자체를 Runnable 로 전달 시, 메서드를 포함하는 클래스가 단일한 Sync 기준이 됨 (ConcurrencyBasicSample)
        // 여기에서도 메서드 전체를 싱크 하므로 성능상 비효율 발생함
//        Thread t1 = new Thread(ConcurrencyBasicSample::syncedRun);
//        Thread t2 = new Thread(ConcurrencyBasicSample::syncedRun);
        // Synced Runnable (right case 3 - better) : 블록 단위 객체 싱크
        // 개선된 점 1 : 로직 블록을 작게 쪼개어 Sync 크기를 줄였음 (성능 개선)
        //             메서드 전체 싱크의 경우보다 Sync 구간이 줄고, 동시 처리 가능 구간이 늘어남
        // 개선된 점 2 : Runnable 객체가 달라도, 일정한 Sync 기준이 적용됨 (오동작 위험 감소)
        //             향후 새로운 위치에서 새 객체를 생성하더라도, 의도치 않게 Sync 위반 가능성이 줄어듦
//        Thread t1 = new Thread(new BlockSyncedRunnable());
//        Thread t2 = new Thread(new BlockSyncedRunnable());
        // Synced lambda (right case 4 - best) : 최소 블록 단위 람다 메서드 싱크
//        Thread t1 = new Thread(syncedRunnable);
//        Thread t2 = new Thread(syncedRunnable);

        t1.start();
        t2.start();

        try {
            t1.join();  // t1 종료 대기
            t2.join();  // t2 종료 대기
            System.out.println(integerArrayList);
            System.out.println("arrayList: "+integerArrayList.size());
            System.out.println(integerVector);
            System.out.println("vectorList: "+integerVector.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
