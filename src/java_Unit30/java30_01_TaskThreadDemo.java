package java_Unit30;

public class java30_01_TaskThreadDemo {
    public static void main(String[] args) {
        // 创建任务，确定三个任务对象 Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // 创建三个线程对象，分别用三个任务对象做参数
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // 启动线程 Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        // 就绪
    }
}

/**
 * 在指定时间内打印指定字符的任务，实现 Runnable 接口并重写 run 方法
 * The task for printing a specified character in specified times
 */
class PrintChar implements Runnable {
    /**
     * 要打印的字符
     * The character to print
     */
    private char charToPrint;
    /**
     * 重复的时间
     * The times to repeat
     */
    private int times;

    /**
     * 构造一个具有指定字符和数量的任务
     * 打印字符的时间
     * Construct a task with specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    /**
     * 覆盖run（）方法以告知系统
     * 要执行什么任务
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
 * 给定n的从1到n打印数字的任务类
 * The task class for printing number from 1 to n for a given n
 */
class PrintNum implements Runnable {
    private int lastNum;

    /**
     * 构造一个任务以打印1、2，... i
     * Construct a task for printing 1, 2, ... i
     */
    public PrintNum(int n) {
        lastNum = n;
    }

    /**
     * 告诉线程如何运行
     * Tell the thread how to run
     */
    @Override
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }

        // Thread 方法测试
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);

            // 为其他线程让步，这个线程总是最后运行完
            Thread.yield();

            // 休眠进程 5ms
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 每次运行结果都不同，我们无法控制线程执行，3个线程交给 JVM，由 JVM 决定运行顺序
