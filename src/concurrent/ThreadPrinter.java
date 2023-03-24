package concurrent;

/**
 * @author CJR
 * @create 2023-02-27-23:50
 */
public class ThreadPrinter implements Runnable {
    private final String name;
    private final Object prev;
    private final Object self;

    private ThreadPrinter(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        while (true) {
            // 多线程并发，不能用if，必须使用whil循环
            synchronized (prev) {
                // 先获取 prev 锁
                synchronized (self) {
                    // 再获取 self 锁
                    System.out.print(name);
                    //打印
                    self.notifyAll();
                    // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                }
                //此时执行完self的同步块，这时self锁才释放。
                try {
                    prev.wait();
                    // 立即释放 prev锁，当前线程休眠，等待唤醒
                    /**
                     * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", b, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);

        new Thread(pa).start();
        Thread.sleep(10);
        //保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
    }
}
