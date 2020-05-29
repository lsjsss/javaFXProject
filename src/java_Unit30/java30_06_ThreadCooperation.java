package java_Unit30;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class java30_06_ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    /**
     * 向帐户添加金额的任务
     * A task for adding an amount to the account
     */
    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try { // Purposely delay it to let the withdraw method proceed
                while (true) {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 从帐户中扣除金额的任务
     * A task for subtracting an amount from the account
     */
    public static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    /**
     * 帐户的内部类
     * An inner class for account
     */
    private static class Account {
        // 创建一个新锁  Create a new lock
        private static Lock lock = new ReentrantLock();

        // 创建一个条件实例  Create a condition
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /**
         * 取款方法
         */
        public void withdraw(int amount) {
            lock.lock(); // Acquire the lock
            try {
                // 余额小于取款的金额
                while (balance < amount) {
                    System.out.println("\t\t\t等待存款 Wait for a deposit");
                    // 条件等待，使当前线程处于等待状态
                    newDeposit.await();
                }

                // 将存款减去，得到新的余额
                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount +
                        "\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // 释放锁 Release the lock
                lock.unlock();
            }
        }

        /**
         * 存款
         */
        public void deposit(int amount) {
            // 获取锁  Acquire the lock
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount +
                        "\t\t\t\t\t" + getBalance());

                // 信号线程等待条件  Signal thread waiting on the condition
                // 存完后，会唤醒其他等待的线程
                newDeposit.signalAll();
            } finally {
                // 释放锁  Release the lock
                lock.unlock();
            }
        }
    }
}
