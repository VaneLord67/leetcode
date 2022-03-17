package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author CJR
 * @create 2022-03-08-19:48
 */
public class AddTest {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread upThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Thread downThread = new Thread(() -> {
                    synchronized (AddTest.class) {
                        System.out.println(Thread.currentThread().getName() + ":cnt=" + count++);
                    }
                });
                downThread.start();
                try {
                    downThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        upThread.start();
        upThread.join();
        System.out.println(Thread.currentThread().getName() + ":reduce count = " + count);
    }

}

