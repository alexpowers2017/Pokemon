package app.cards;

public class Card {
    private final String name;
    private final String category;

    public String getName() { return this.name; }
    public String getCategory() { return this.category; }

    public Card(String cardName, String category) {
        this.name = cardName;
        this.category = category;
    }

}
