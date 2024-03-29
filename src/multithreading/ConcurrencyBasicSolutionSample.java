package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyBasicSolutionSample {
    private int passCount = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ConcurrencyBasicSolutionSample example = new ConcurrencyBasicSolutionSample();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> example.process());
            thread.start();
        }
    }

    private synchronized void process() {  // 메서드에 synchronized 키워드를 사용해 스레드 동기화
        if (passCount < 10) {
            try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("passCount: " + (++passCount));
        } else {
            System.err.println("blocked by passCount condition");
        }
    }

    private void process2() {
        synchronized (this) {  // synchronized 블록을 사용해 스레드 동기화
            if (passCount < 10) {
                try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("passCount: " + (++passCount));
            } else {
                System.err.println("blocked by passCount condition");
            }
        }
    }

    private void process3() {
        lock.lock(); // lock 을 통해 스레드가 하나씩만 통과할 수 있는 임계영역 생성
        // 아래 작업들은 임계영역에서 이루어지므로 스레드 안전
        if (passCount < 10) {
            try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("passCount: " + (++passCount));
            lock.unlock();  // 중요 작업을 마친 경우 임계영역 해제
        } else {
            System.err.println("blocked by passCount condition");
            lock.unlock();  // 모든 케이스에 lock 해제를 빠뜨리지 말 것!
        }
    }
}