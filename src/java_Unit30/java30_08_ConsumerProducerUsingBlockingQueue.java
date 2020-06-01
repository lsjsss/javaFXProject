package java_Unit30;

import java.util.concurrent.*;

/**
 * ʹ���������е������� �� ������
 */
public class java30_08_ConsumerProducerUsingBlockingQueue {
    /**
     * ʹ����������(����)������Ϊ2��
     * ����������ʵ��������(ͬ��)���ܣ�����Ҫ�ٱ���һ��ͬ������
     */
    private static ArrayBlockingQueue<Integer> buffer =
            new ArrayBlockingQueue<Integer>(2);

    public static void main(String[] args) {
        // �������������̵߳��̳߳�  Create a thread pool with two threads
        // ����һ���̳߳�(ִ����)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // ��������������̳߳�
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        // �ر��̳߳�
        executor.shutdown();
    }

    /**
     * �򻺳������int������
     * A task for adding an int to the buffer
     */
    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    // ���κ�ֵ��ӵ�������������1  Add any value to the buffer, say, 1
                    // ʹ�� put() �������� write() ����
                    buffer.put(i++);
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
                    System.out.println("\t\t\t�������Ķ� Consumer reads " + buffer.take());
                    // ���߳̽���˯��״̬  Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
