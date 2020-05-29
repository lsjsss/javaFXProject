package java_Unit30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class java30_07_ConsumerProducer {
    /**
     * ������̬���������ֿ⣩
     */
    private static Buffer buffer = new Buffer();

    public static void main(String[] args) {
        // �������������̵߳��̳߳�  Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    /**
     * �򻺳������int�������ڲ���
     * A task for adding an int to the buffer
     */
    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("������д�� Producer writes " + i);
                    // �򻺳������ֵ  Add a value to the buffer
                    buffer.write(i++);
                    // ���߳̽���˯��״̬  Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * ���ڴӻ�������ȡ��ɾ��int������
     * A task for reading and deleting an int from the buffer
     */
    private static class ConsumerTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\t�������Ķ� Consumer reads " + buffer.read());
                    // Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * ���������ڲ���
     * An inner class for buffer
     */
    private static class Buffer {
        // ��������С����Ϊ1������  buffer size
        private static final int CAPACITY = 1;

        // ʹ�����Ա� LinkedList ��ʵ�ֻ�����
        private java.util.LinkedList<Integer> queue =
                new java.util.LinkedList<Integer>();

        // ����һ������  Create a new lock
        private static Lock lock = new ReentrantLock();

        // ������������  Create two conditions
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        /**
         * дһ����������������������
         */
        public void write(int value) {
            // ��ȡ��  Acquire the lock
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println("�ȴ�������������  Wait for notFull condition");
                    notFull.await();
                }

                queue.offer(value);
                // �źŲ�Ϊ��״̬  Signal notEmpty condition
                notEmpty.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // �ͷ���  Release the lock
                lock.unlock();
            }
        }

        public int read() {
            int value = 0;
            // ��ȡ��  Acquire the lock
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("\t\t\t�ȴ�notEmpty����  Wait for notEmpty condition");
                    notEmpty.await();
                }

                value = queue.remove();
                // �ź�δ��  Signal notFull condition
                notFull.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // �ͷ���  Release the lock
                lock.unlock();
                return value;
            }
        }
    }
}
