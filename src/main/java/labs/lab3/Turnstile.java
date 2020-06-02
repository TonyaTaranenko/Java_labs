package labs.lab3;

import labs.lab3.card.BaseCard;
import labs.lab3.card.CardRegistry;
import labs.lab3.card.CardType;

public class Turnstile {
    private CardRegistry registry;

    public Turnstile(CardRegistry registry) {
        this.registry = registry;
    }

    public boolean accept(String cardId) {
        BaseCard card = registry.getById(cardId);

        if (card == null) {
            registry.eventNotFound(cardId);
            return false;
        }

        if (card.isBanned()) {
            registry.eventBanned(card);
            return false;
        }

        if (!card.isActive()) {
            registry.eventNotActive(card);
            return false;
        }

        if (card.getType() == CardType.PREFERENTIAL) {
            warnPreferential();
        } else if (card.getType() == CardType.VIP) {
            warnVIP();
        }

        card.use();

        registry.eventOk(card);
        return true;
    }

    private void warnPreferential() {
        System.out.println("WARNING! Preferential card used");
    }

    private void warnVIP() {
        System.out.println("WARNING! VIP card used");
    }
}
