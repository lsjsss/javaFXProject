package java_Unit30;

import java.util.concurrent.Semaphore;

public class java30_09_Account {
    // Create a semaphore
    private static Semaphore semaphore = new Semaphore(1);
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        try {
            // Acquire a permit
            semaphore.acquire();
            int newBalance = balance + amount;

            Thread.sleep(5);
            balance = newBalance;
        } catch (InterruptedException ex) {
        }
        finally {
            semaphore.release();
        }
    }
}
