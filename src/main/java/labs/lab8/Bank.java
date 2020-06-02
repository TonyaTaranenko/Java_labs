package labs.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void transfer(Account from, Account to, int amount) {
        Object lock1 = from.getId() < to.getId() ? from : to;
        Object lock2 = from.getId() < to.getId() ? to : from;
        synchronized (lock1) {
            synchronized (lock2) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public void transferWithoutSynchronized(Account from, Account to, int amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public Account randomAccount() {
        return accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
    }

    public void newAccount(int initialValue) {
        Account ret = new Account(accounts.size() + 1, initialValue);
        accounts.add(ret);
    }

    public long totalAmount() {
        long ret = 0;
        for (Account account : accounts) {
            ret += account.getValue();
        }
        return ret;
    }
}
