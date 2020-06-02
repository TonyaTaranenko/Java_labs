package labs.lab8;

public class Account {
    private int id;
    private int value;

    public Account(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public void withdraw(int amount) {
        value -= amount;
    }

    public void deposit(int amount) {
        value += amount;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
