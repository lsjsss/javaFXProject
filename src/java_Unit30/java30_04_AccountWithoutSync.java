package java_Unit30;

import java.util.concurrent.*;

public class java30_04_AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        // ����һ���̳߳�
        ExecutorService executor = Executors.newCachedThreadPool();

        // ����������100���߳�  Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // �ȵ������������  Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    /**
     * �������ʻ����һ��Ǯ���߳�
     * A thread for adding a penny to the account
     */
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    /**
     * �ʻ����ڲ���
     * An inner class for account
     */
    private static class Account {
        // ����
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /** synchronized �ؼ��֣� ʹ����ͬ�� */
        public synchronized void deposit(int amount) {
            int newBalance = balance + amount;

            // ������Ӵ��ӳ��ԷŴ�
            // ���������⣬ʹ�����ڲ鿴��
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
 * ͨ���ӹؼ��� synchronized ʹ�߳�ͬ����ʹ���̱߳�ð�ȫ
 */
