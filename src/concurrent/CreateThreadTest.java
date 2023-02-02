package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author CJR
 * @create 2023-02-02-14:05
 */
public class CreateThreadTest {
    public static void main(String[] args) {
        // 1. thread
        MyThread thread1 = new MyThread();
        thread1.start();
        // thread匿名类
        Thread thread2 = new MyThread() {
            @Override
            public void run() {
                System.out.println("匿名子类");
            }
        };
        thread2.start();
        // 2. runnable
        // 放入thread的就是一个runnable的target
        Thread thread3 = new Thread(() -> System.out.println("runnable"));
        thread3.start();
        // 3. callable + futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCall());
        // futureTask既是runnable又是future
        Thread thread4 = new Thread(futureTask);
        thread4.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 4. 线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // execute无返回值 submit有返回值
        threadPool.execute(new MyRun());
        threadPool.submit(new MyRun());
        threadPool.submit(new MyCall());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyCall());
        threadPool.submit(futureTask2);
        threadPool.shutdown();
        try {
            System.out.println(futureTask2.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承thread");
    }
}

class MyCall implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("执行call");
        return new Random().nextInt();
    }
}

class MyRun implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable接口");
    }
}