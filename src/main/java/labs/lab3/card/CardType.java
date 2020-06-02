package labs.lab3.card;

public enum CardType {
    DEFAULT(1.0),
    PREFERENTIAL(0.8),
    VIP(2.0);

    private double costMultiplier;

    CardType(double costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

    public double getCostMultiplier() {
        return costMultiplier;
    }
}
