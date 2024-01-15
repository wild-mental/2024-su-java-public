package multithreading;

import java.awt.*;

public class MultiThreadingSample {
    public static void main(String[] args) {
        int reps = 100;
        int delayTime = 10;
        Toolkit tk = Toolkit.getDefaultToolkit();
        // beepThread 선언
        // (1) 익명 자식객체를 구현하는 Thread 생성 방식
        // Thread 클래스를 인라인으로 재정의한 익명클래스의 객체를 생성한다.
        Thread beepThread = new Thread() {
            @Override
            public void run () {
//                long startTime = System.currentTimeMillis();
                for (int i=0; i<reps; i++) {
                    tk.beep();
                    // delay 를 위해 스레드 sleep
                    try { Thread.sleep(delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
                }
//                long elapsedTime = System.currentTimeMillis() - startTime;
//                System.out.println("beeping elapsed time: "+elapsedTime+"ms");
            }
        };
        // printThread 선언
        // (2) 람다식을 사용한 익명 구현객체를 Thread 생성자에 전달하는 방식
        // 람다 표현식으로 익명 구현 클래스의 객체를 생성해 Runnable 인터페이스를 받는 Thread 클래스의 생성자에 전달한다.
        Thread printThread = new Thread(() -> {
//            long startTime = System.currentTimeMillis();
            for (int i=0; i<reps; i++) {
                System.out.println("Beep"+i);
                // delay 를 위해 스레드 sleep
                try { Thread.sleep(delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            System.out.println("printing elapsed time: "+elapsedTime+"ms");
        });
        //
//        beepThread.setDaemon(true);
//        printThread.setDaemon(true);

        // 두 스레드 실행
//        printThread.start();
//        beepThread.start();

        // 두 스레드 실행 (with ElapsedTime)
        boolean isOccupyThread = true;
        printThreadWithElapsed(reps, delayTime, isOccupyThread);
        beepThreadWithElapsed(tk, reps, delayTime, isOccupyThread);
    }

    // Java 스럽게 만들기
    public static class ThreadWithElapsed extends Thread {
        public  ThreadWithElapsed(Runnable target) {
            super(target);
        }
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            super.run();
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println(this.getName()+" done at elapsed time:"+elapsedTime+"ms");
        }
    }
    public static void printThreadWithElapsed(int reps, int delayTime, boolean isOccupyThread) {
        ThreadWithElapsed printElapsedThread = new ThreadWithElapsed(() -> {
            for (int i = 0; i < reps; i++) {
                System.out.println("Beep" + i);
                delayMethod(delayTime, isOccupyThread);
            }
        }
        );
        printElapsedThread.setName("printElapsedThread");
        printElapsedThread.start();
    }
    public static void beepThreadWithElapsed(Toolkit tk, int reps, int delayTime, boolean isOccupyThread) {
        ThreadWithElapsed beepElapsedThread = new ThreadWithElapsed(() -> {
            for (int i = 0; i < reps; i++) {
                tk.beep();
                delayMethod(delayTime, isOccupyThread);
            }
        }
        );
        beepElapsedThread.setName("beepElapsedThread");
        beepElapsedThread.start();
    }
    public static void delayMethod(int delayTime, boolean isOccupyThread) {
        if(isOccupyThread) {
            // delay 방식을 sleep 형에서 CPU 점유형으로 변경
            long startTime = System.currentTimeMillis();
            long elapsedTime = 0;
            while (elapsedTime < delayTime) {
                // Update elapsed time
                elapsedTime = System.currentTimeMillis() - startTime;
            }
        } else {
            try { Thread.sleep(delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
        }
    }
}
