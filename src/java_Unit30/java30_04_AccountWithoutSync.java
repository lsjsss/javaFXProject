package java_Unit30;

import java.util.concurrent.*;

public class java30_04_AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        // 创建并启动100个线程  Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // 等到所有任务完成  Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    /**
     * 用于向帐户添加一分钱的线程
     * A thread for adding a penny to the account
     */
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    /**
     * 帐户的内部类
     * An inner class for account
     */
    private static class Account {
        // 加锁
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /** synchronized 关键字： 使进程同步 */
        public synchronized void deposit(int amount) {
            int newBalance = balance + amount;

            // 故意添加此延迟以放大
            // 数据损坏问题，使其易于查看。
            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see.
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }

            balance = newBalance;
        }
    }
}
/**
 * 通过加关键词 synchronized 使线程同步，使得线程变得安全
 */
