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

    static class WrongSyncedRunnable implements Runnable {
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

    static class RightSyncedRunnable implements Runnable {
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

    public static void main(String[] args) {
        // Not Synced
//        Thread t1 = new Thread(runnable);
//        Thread t2 = new Thread(runnable);
        // Synced Runnable (wrong case)
//        Thread t1 = new Thread(new WrongSyncedRunnable());
//        Thread t2 = new Thread(new WrongSyncedRunnable());
        // Synced Runnable (right case)
        Thread t1 = new Thread(new RightSyncedRunnable());
        Thread t2 = new Thread(new RightSyncedRunnable());
        // Synced Method (right case)
//        Thread t1 = new Thread(Main::syncedRun);
//        Thread t2 = new Thread(Main::syncedRun);
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
