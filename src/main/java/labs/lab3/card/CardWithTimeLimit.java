package labs.lab3.card;

import labs.lab3.TimeUtil;

public class CardWithTimeLimit extends BaseCard {
    private int timeFrom, timeTo;

    public CardWithTimeLimit(String id, CardType type, int timeFrom, int timeTo) {
        super(id, type);
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    @Override
    public boolean isActive() {
        int currentTime = TimeUtil.getCurrentTimeInHours();
        return currentTime >= timeFrom && currentTime <= timeTo;
    }

    @Override
    protected double getBaseCost() {
        return (timeTo - timeFrom) * 7.5;
    }

    @Override
    public String toString() {
        return "CardWithTimeLimit{" +
                "timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", id='" + id + '\'' +
                ", banned=" + banned +
                ", cost=" + getCost() +
                '}';
    }
}
