package concurrent;

/**
 * @author CJR
 * @create 2023-02-27-23:24
 * reference: <a href="https://blog.csdn.net/abc123mma/article/details/128153511">...</a>
 */

public class PrintTest {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("A");
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("B");
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
