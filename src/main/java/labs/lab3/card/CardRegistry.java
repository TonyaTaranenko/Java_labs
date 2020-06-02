package labs.lab3.card;

import labs.lab3.TimeUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class CardRegistry {
    private Map<String, BaseCard> cardMap;
    private List<CardRegistryEvent> events;

    public CardRegistry() {
        this.cardMap = new LinkedHashMap<>();
        this.events = new ArrayList<>();
    }

    public BaseCard newCardWithLiftLimit(CardType type, int liftCount) {
        return putCard(new CardWithLiftLimit(randomId(), type, liftCount));
    }

    public BaseCard newMorningCard(CardType type) {
        int todayStartTime = TimeUtil.getTodayStartTimeInHours();
        return putCard(new CardWithTimeLimit(randomId(), type, todayStartTime + 9, todayStartTime + 14));
    }

    public BaseCard newEveningCard(CardType type) {
        int todayStartTime = TimeUtil.getTodayStartTimeInHours();
        return putCard(new CardWithTimeLimit(randomId(), type, todayStartTime + 14, todayStartTime + 19));
    }

    public BaseCard newNightCard(CardType type) {
        int todayStartTime = TimeUtil.getTodayStartTimeInHours();
        return putCard(new CardWithTimeLimit(randomId(), type, todayStartTime + 19, todayStartTime + 24));
    }

    public BaseCard newNDaysCard(CardType type, int nDays) {
        int todayStartTime = TimeUtil.getTodayStartTimeInHours();
        int nHours = 24 * nDays;
        return putCard(new CardWithTimeLimit(randomId(), type, todayStartTime, todayStartTime + nHours));
    }

    public BaseCard newSeasonCard(CardType type) {
        int seasonStartTime = TimeUtil.getSeasonStartTimeInHours();
        int nHours = 24 * 90;
        return putCard(new CardWithTimeLimit(randomId(), type, seasonStartTime, seasonStartTime + nHours));
    }

    private BaseCard putCard(BaseCard card) {
        cardMap.put(card.getId(), card);
        return card;
    }

    public BaseCard getById(String cardId) {
        return cardMap.get(cardId);
    }

    public void ban(BaseCard card) {
        card.setBanned(true);
    }

    public void eventNotFound(String cardId) {
        events.add(new CardRegistryEvent("card not found", cardId));
    }

    public void eventBanned(BaseCard card) {
        events.add(new CardRegistryEvent("card is banned", card));
    }

    public void eventNotActive(BaseCard card) {
        events.add(new CardRegistryEvent("card is not active", card));
    }

    public void eventOk(BaseCard card) {
        events.add(new CardRegistryEvent("passage allowed", card));
    }

    public List<CardRegistryEvent> getEvents() {
        return events;
    }

    public List<CardRegistryEvent> getEventsByCardType(CardType type) {
        List<CardRegistryEvent> ret = new ArrayList<>();
        for (CardRegistryEvent event : events) {
            if (event.getCard().getType() == type) {
                ret.add(event);
            }
        }
        return ret;
    }

    public List<CardRegistryEvent> getEventsByCardId(String cardId) {
        List<CardRegistryEvent> ret = new ArrayList<>();
        for (CardRegistryEvent event : events) {
            if (event.getCard().getId().equals(cardId)) {
                ret.add(event);
            }
        }
        return ret;
    }

    private String randomId() {
        while (true) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                builder.append((char) ThreadLocalRandom.current().nextInt('a', 'z' + 1));
            }
            String ret = builder.toString();
            if (!cardMap.containsKey(ret)) {
                return ret;
            }
        }
    }
}
