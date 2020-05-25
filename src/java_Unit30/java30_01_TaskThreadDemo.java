package java_Unit30;

public class java30_01_TaskThreadDemo {
    public static void main(String[] args) {
        // ��������ȷ������������� Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // ���������̶߳��󣬷ֱ��������������������
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // �����߳� Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        // ����
    }
}

/**
 * ��ָ��ʱ���ڴ�ӡָ���ַ�������ʵ�� Runnable �ӿڲ���д run ����
 * The task for printing a specified character in specified times
 */
class PrintChar implements Runnable {
    /**
     * Ҫ��ӡ���ַ�
     * The character to print
     */
    private char charToPrint;
    /**
     * �ظ���ʱ��
     * The times to repeat
     */
    private int times;

    /**
     * ����һ������ָ���ַ�������������
     * ��ӡ�ַ���ʱ��
     * Construct a task with specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    /**
     * ����run���������Ը�֪ϵͳ
     * Ҫִ��ʲô����
     * Override the run() method to tell the system
     * what the task to perform
     */
    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

/**
 * ����n�Ĵ�1��n��ӡ���ֵ�������
 * The task class for printing number from 1 to n for a given n
 */
class PrintNum implements Runnable {
    private int lastNum;

    /**
     * ����һ�������Դ�ӡ1��2��... i
     * Construct a task for printing 1, 2, ... i
     */
    public PrintNum(int n) {
        lastNum = n;
    }

    /**
     * �����߳��������
     * Tell the thread how to run
     */
    @Override
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }

        // Thread ��������
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);

            // Ϊ�����߳��ò�������߳��������������
            Thread.yield();

            // ���߽��� 5ms
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// ÿ�����н������ͬ�������޷������߳�ִ�У�3���߳̽��� JVM���� JVM ��������˳��
