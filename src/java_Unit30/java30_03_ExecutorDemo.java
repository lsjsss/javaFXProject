package java_Unit30;

import java.util.concurrent.*;

public class java30_03_ExecutorDemo {
    public static void main(String[] args) {
        // 创建最多包含三个线程的固定线程池  Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 将可运行任务提交给执行者  Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        // 关闭执行器  Shut down the executor
        executor.shutdown();
    }
}
/**
 * 提高执行效率，把线程放到线程池；
 * 1.创建线程池，使用 Executors.newFixedThreadPool() 创建线程池；
 * 2.把线程放到线程池中，exe: 执行；
 * 3.关闭线程池；
 */

