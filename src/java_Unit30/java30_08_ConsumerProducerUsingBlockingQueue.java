package java_Unit30;

import java.util.concurrent.*;

/**
 * 使用阻塞队列的生产者 、 消费者
 */
public class java30_08_ConsumerProducerUsingBlockingQueue {
    /**
     * 使用阻塞队列(数组)，长度为2；
     * 阻塞队列中实现了阻塞(同步)功能，不需要再编制一个同步的类
     */
    private static ArrayBlockingQueue<Integer> buffer =
            new ArrayBlockingQueue<Integer>(2);

    public static void main(String[] args) {
        // 创建具有两个线程的线程池  Create a thread pool with two threads
        // 创建一个线程池(执行器)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 把两个任务加入线程池
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 向缓冲区添加int的任务
     * A task for adding an int to the buffer
     */
    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    // 将任何值添加到缓冲区，例如1  Add any value to the buffer, say, 1
                    // 使用 put() 方法代替 write() 方法
                    buffer.put(i++);
                    // 让线程进入睡眠状态  Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 用于从缓冲区读取和删除int的任务
     * A task for reading and deleting an int from the buffer
     */
    private static class ConsumerTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\t消费者阅读 Consumer reads " + buffer.take());
                    // 让线程进入睡眠状态  Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
