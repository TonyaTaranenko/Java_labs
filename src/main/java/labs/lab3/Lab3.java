package labs.lab3;

import labs.lab3.card.BaseCard;
import labs.lab3.card.CardRegistry;
import labs.lab3.card.CardType;

public class Lab3 {
    public static void main(String[] args) {
        CardRegistry registry = new CardRegistry();
        Turnstile turnstile = new Turnstile(registry);

        BaseCard card = registry.newCardWithLiftLimit(CardType.PREFERENTIAL, 3);
        System.out.println(card);

        System.out.println("accept #1: " + turnstile.accept(card.getId()));
        System.out.println("accept #2: " + turnstile.accept(card.getId()));
        System.out.println("accept #3: " + turnstile.accept(card.getId()));
        System.out.println("accept #4: " + turnstile.accept(card.getId()));

        System.out.println();

        System.out.println("events:");
        registry.getEvents().forEach(System.out::println);
    }
}
