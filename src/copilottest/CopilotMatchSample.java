package copilottest;

import multithreading.MultiThreadingSample;

public class CopilotMatchSample {
    CopilotMatchSample() {
        System.out.println("CopilotMatchSample constructor");
    }

    public static void main(String[] args) {
        System.out.println("CopilotMatchSample main");
        CopilotMatchSample copilotMatchSample = new CopilotMatchSample();
    }

    public void test() {
        System.out.println("CopilotMatchSample test");
    }

    public void test2() {
        System.out.println("CopilotMatchSample test2");
    }

    public void test3() {
        System.out.println("CopilotMatchSample test3");
    }

    public void test4() {
        System.out.println("CopilotMatchSample test4");
    }

    public void getPropertiesFromKMS() {
        long startTime = System.currentTimeMillis();
        System.out.println("CopilotMatchSample getPropertiesFromKMS");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("CopilotMatchSample getPropertiesFromKMS elapsed time: "+elapsedTime+"ms");
        copilottest.CopilotMatchSample copilotMatchSample = new copilottest.CopilotMatchSample();
        copilotMatchSample.test();
        copilotMatchSample.test2();
        copilotMatchSample.test3();
        copilotMatchSample.test4();
        boolean isOccupyThread = true;
//        doSomethingWithElapsed(isOccupyThread);
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("CopilotMatchSample getPropertiesFromKMS elapsed time: "+elapsedTime+"ms");
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
    }
    public void doSomethingWithElapsed(boolean isOccupyThread) {
        long startTime = System.currentTimeMillis();
        System.out.println("CopilotMatchSample doSomethingWithElapsed");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("CopilotMatchSample doSomethingWithElapsed elapsed time: "+elapsedTime+"ms");
        if (isOccupyThread) {
            MultiThreadingSample.ThreadWithElapsed threadWithElapsed = new MultiThreadingSample.ThreadWithElapsed(() -> {
                System.out.println("CopilotMatchSample doSomethingWithElapsed ThreadWithElapsed");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadWithElapsed.start();
            try {
                threadWithElapsed.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("CopilotMatchSample doSomethingWithElapsed ThreadWithElapsed");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("CopilotMatchSample doSomethingWithElapsed elapsed time: "+elapsedTime+"ms");
    }
}
