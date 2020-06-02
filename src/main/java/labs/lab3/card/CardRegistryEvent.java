package labs.lab3.card;

public class CardRegistryEvent {
    private String message;
    private BaseCard card;
    private String cardId;

    public CardRegistryEvent(String message, BaseCard card) {
        this.message = message;
        this.card = card;
    }

    public CardRegistryEvent(String message, String cardId) {
        this.message = message;
        this.cardId = cardId;
    }

    public String getMessage() {
        return message;
    }

    public BaseCard getCard() {
        return card;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        if (card != null) {
            return "CardRegistryEvent{" +
                    "message='" + message + '\'' +
                    ", card=" + card +
                    '}';
        } else {
            return "CardRegistryEvent{" +
                    "message='" + message + '\'' +
                    ", cardId='" + cardId + '\'' +
                    '}';
        }
    }
}
