package labs.lab8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankTest {
    @Test
    void testTransferWithoutSynchronized() throws InterruptedException {
        assertFalse(testTransfer(false));
    }

    @Test
    void testTransfer() throws InterruptedException {
        assertTrue(testTransfer(true));
    }

    private static boolean testTransfer(boolean useSynchronized) throws InterruptedException {
        Bank bank = new Bank();

        for (int i = 0; i < 300; i++) {
            bank.newAccount(ThreadLocalRandom.current().nextInt(1_000, 10_000));
        }

        long amountBefore = bank.totalAmount();

        Thread[] threads = new Thread[3000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                if (useSynchronized) {
                    for (int j = 0; j < 1000; j++) {
                        bank.transfer(bank.randomAccount(), bank.randomAccount(), 100);
                    }
                } else {
                    for (int j = 0; j < 1000; j++) {
                        bank.transferWithoutSynchronized(bank.randomAccount(), bank.randomAccount(), 100);
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long amountAfter = bank.totalAmount();

        return amountBefore == amountAfter;
    }
}