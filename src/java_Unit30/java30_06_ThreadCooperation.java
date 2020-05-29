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
     * ���ʻ���ӽ�������
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
     * ���ʻ��п۳���������
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
     * �ʻ����ڲ���
     * An inner class for account
     */
    private static class Account {
        // ����һ������  Create a new lock
        private static Lock lock = new ReentrantLock();

        // ����һ������ʵ��  Create a condition
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /**
         * ȡ���
         */
        public void withdraw(int amount) {
            lock.lock(); // Acquire the lock
            try {
                // ���С��ȡ��Ľ��
                while (balance < amount) {
                    System.out.println("\t\t\t�ȴ���� Wait for a deposit");
                    // �����ȴ���ʹ��ǰ�̴߳��ڵȴ�״̬
                    newDeposit.await();
                }

                // ������ȥ���õ��µ����
                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount +
                        "\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                // �ͷ��� Release the lock
                lock.unlock();
            }
        }

        /**
         * ���
         */
        public void deposit(int amount) {
            // ��ȡ��  Acquire the lock
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount +
                        "\t\t\t\t\t" + getBalance());

                // �ź��̵߳ȴ�����  Signal thread waiting on the condition
                // ����󣬻ỽ�������ȴ����߳�
                newDeposit.signalAll();
            } finally {
                // �ͷ���  Release the lock
                lock.unlock();
            }
        }
    }
}
