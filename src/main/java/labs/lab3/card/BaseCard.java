package labs.lab3.card;

public abstract class BaseCard {
    protected String id;
    protected CardType type;
    protected boolean banned;

    protected BaseCard(String id, CardType type) {
        this.id = id;
        this.type = type;
        this.banned = false;
    }

    public void use() {
    }

    public abstract boolean isActive();

    public double getCost() {
        return type.getCostMultiplier() * getBaseCost();
    }

    protected abstract double getBaseCost();

    public String getId() {
        return id;
    }

    public CardType getType() {
        return type;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
