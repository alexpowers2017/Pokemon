package app.cards.energycards;

import app.cards.Card;
import app.energy.Energy;


public class EnergyCard extends Card {
    private final Energy[] energies;
    private final String name;

    public Energy[] getEnergies() { return this.energies; }
    public String getName() { return this.name; }

    public EnergyCard(String cardName, Energy energy) {
        super(cardName, "energy");
        this.energies = new Energy[]{energy};
        this.name = cardName;
    }

    public EnergyCard(String cardName, Energy[] energies) {
        super(cardName, "energy");
        this.energies = energies;
        this.name = cardName;
    }
}


