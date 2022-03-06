package app.cards;

public class Card {
    private final String name;
    private final String type;

    public String getName() { return this.name; }
    public String getType() { return this.type; }

    public Card(String cardName, String cardType) {
        this.name = cardName;
        this.type = cardType;
    }

}
