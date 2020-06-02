package labs.lab3;

import labs.lab3.card.BaseCard;
import labs.lab3.card.CardRegistry;
import labs.lab3.card.CardType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurnstileTest {
    @Test
    void testAccept() {
        CardRegistry registry = new CardRegistry();
        Turnstile turnstile = new Turnstile(registry);

        BaseCard card = registry.newCardWithLiftLimit(CardType.VIP, 3);

        assertTrue(turnstile.accept(card.getId()));
        assertTrue(turnstile.accept(card.getId()));
        assertTrue(turnstile.accept(card.getId()));

        assertFalse(turnstile.accept(card.getId()));
    }
}