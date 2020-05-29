package java_Unit30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class java30_07_ConsumerProducer {
    /**
     * 创建静态缓冲区（仓库）
     */
    private static Buffer buffer = new Buffer();

    public static void main(String[] args) {
        // 创建具有两个线程的线程池  Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    /**
     * 向缓冲区添加int的任务，内部类
     * A task for adding an int to the buffer
     */
    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("生产者写道 Producer writes " + i);
                    // 向缓冲区添加值  Add a value to the buffer
                    buffer.write(i++);
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
                    System.out.println("\t\t\t消费者阅读 Consumer reads " + buffer.read());
                    // Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 缓冲区的内部类
     * An inner class for buffer
     */
    private static class Buffer {
        // 缓冲区大小容量为1，常量  buffer size
        private static final int CAPACITY = 1;

        // 使用线性表 LinkedList 来实现缓冲区
        private java.util.LinkedList<Integer> queue =
                new java.util.LinkedList<Integer>();

        // 创建一个新锁  Create a new lock
        private static Lock lock = new ReentrantLock();

        // 创建两个条件  Create two conditions
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        /**
         * 写一个整数到缓冲区，生产者
         */
        public void write(int value) {
            // 获取锁  Acquire the lock
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println("等待不完整的条件  Wait for notFull condition");
                    notFull.await();
                }

                queue.offer(value);
                // 信号不为空状态  Signal notEmpty condition
                notEmpty.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // 释放锁  Release the lock
                lock.unlock();
            }
        }

        public int read() {
            int value = 0;
            // 获取锁  Acquire the lock
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("\t\t\t等待notEmpty条件  Wait for notEmpty condition");
                    notEmpty.await();
                }

                value = queue.remove();
                // 信号未满  Signal notFull condition
                notFull.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // 释放锁  Release the lock
                lock.unlock();
                return value;
            }
        }
    }
}
