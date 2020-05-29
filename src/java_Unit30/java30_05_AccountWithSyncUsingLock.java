package java_Unit30;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class java30_05_AccountWithSyncUsingLock {
    private static Account account = new Account();
    // static 静态方法：不需要实例来调用，用类来调用
    // 静态属性，是整个类所共有的

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // 创建并启动100个线程  Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("什么是平衡  What is balance ? " + account.getBalance());
    }

    /**
     * 用于向帐户添加一分钱的线程
     * A thread for adding a penny to the account
     */
    public static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    /**
     * 帐户的内部类
     * An inner class for account
     */
    public static class Account {
        // 创建锁，没有使用公平策略  Create a lock
        private static Lock lock = new ReentrantLock();
        private int balance = 0;

        // 每个账号有两个属性: lock, balance
        // 一个账号只能有一把锁
        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            // 获取锁  Acquire the lock
            // 任务一开始加锁
            lock.lock();

            try {
                int newBalance = balance + amount;

                // 故意添加此延迟以放大
                // 数据损坏问题，使其易于查看。
                // This delay is deliberately added to magnify the
                // data-corruption problem and make it easy to see.
                // 模拟真实过程， 休眠 5 ms
                Thread.sleep(5);

                // 正常，会解锁，如果出现异常，则不能解锁
                balance = newBalance;
            } catch (InterruptedException ex) {
            } finally {
                // 无论是否出现异常，都会释放锁；任务结束时释放锁
                lock.unlock(); // Release the lock
            }
        }
    }
}
// 加锁位置：在账户上加锁，把锁作为他的一个属性：任务一开始加锁，任务结束时释放锁
