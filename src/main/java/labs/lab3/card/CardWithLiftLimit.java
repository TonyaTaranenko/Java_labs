package labs.lab3.card;

public class CardWithLiftLimit extends BaseCard {
    private int liftCount;
    private double baseCost;

    public CardWithLiftLimit(String id, CardType type, int liftCount) {
        super(id, type);
        this.liftCount = liftCount;
        this.baseCost = 5 * liftCount;
    }

    @Override
    public void use() {
        if (liftCount == 0) {
            throw new IllegalStateException();
        }
        liftCount--;
    }

    @Override
    public boolean isActive() {
        return liftCount > 0;
    }

    @Override
    public double getBaseCost() {
        return baseCost;
    }

    @Override
    public String toString() {
        return "CardWithLiftLimit{" +
                "liftCount=" + liftCount +
                ", id='" + id + '\'' +
                ", banned=" + banned +
                ", cost=" + getCost() +
                '}';
    }
}
