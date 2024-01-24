package multithreading;

import java.awt.*;

public class SimpleMultithreadingSample {
    static boolean beepOn = true;
    static class BeepController {
        int reps;
        int delayTime;

        public BeepController(int reps, int delayTime) {
            this.reps = reps;
            this.delayTime = delayTime;
        }
    }
    public static void main(String[] args) {
        BeepController beepController = new BeepController(20, 300);
        Toolkit tk = Toolkit.getDefaultToolkit();

        // 스레드 만드는 방법
        // (1) Thread 인라인 오버라이딩 (익명 객체 생성)
        Thread sampleBeepThread1 = new Thread() {
            @Override
            public void run() {
                for (int i=0; i<beepController.reps; i++) {
                    if(beepOn) {
                        tk.beep();
                        // delay 를 위해 스레드 sleep
                        try { Thread.sleep(beepController.delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
                    }
                }
            }
        };
        // 스레드 만드는 방법
        // (2) Runnable 인라인 오버라이딩 (익명 객체)
        Thread sampleBeepThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(beepOn) {
                    try { Thread.sleep(beepController.delayTime / 3); } catch (InterruptedException e) { throw new RuntimeException(e); }
                    for (int i = 0; i < beepController.reps; i++) {
                        tk.beep();
                        // delay 를 위해 스레드 sleep
                        try { Thread.sleep(beepController.delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
                    }
                }
            }
        });
        // 스레드 만드는 방법 (Best)
        // (3) Runnable lambda 식 사용
        Thread sampleBeepThread3 = new Thread(() -> {
            if(beepOn) {
                try { Thread.sleep(beepController.delayTime / 3 * 2); } catch (InterruptedException e) { throw new RuntimeException(e); }
                for (int i = 0; i < beepController.reps; i++) {
                    tk.beep();
                    // delay 를 위해 스레드 sleep
                    try { Thread.sleep(beepController.delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
                }
            }
        });

        sampleBeepThread1.start();  // 즉시 beep 시작
        sampleBeepThread2.start();  // 100 ms 후 beep 시작
//        sampleBeepThread3.start();  // 200 ms 후 beep 시작
    }
}
