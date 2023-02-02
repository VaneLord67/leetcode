package produce_consume;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author CJR
 * @create 2023-02-01-23:43
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            try {
                for(;;) {
                    int product = new Random().nextInt();
                    queue.put(product);
                    System.out.println("生产: " + product);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for(;;) {
                    Integer product = queue.take();
                    System.out.println("消费: " + product);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }
}
