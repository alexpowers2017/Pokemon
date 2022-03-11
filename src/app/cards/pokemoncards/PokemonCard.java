package app.cards.pokemoncards;

import app.cards.Card;
import app.energy.Energy;
import app.type.TypedObject;



public class PokemonCard extends TypedObject implements Card {
    private final String name;
    private final Integer startingHp;
    private final Energy[] retreatCost;

    private Integer hp;

    public String getName() { return this.name; }
    public Integer getStartingHp() { return this.startingHp; }
    public Energy[] getRetreatCost() { return this.retreatCost; }

    public Integer getHp() { return this.hp; }


    public PokemonCard(String name, Integer startingHp, String typeName, Energy[] retreatCost) {
        super(typeName);
        this.name = name;
        this.startingHp = startingHp;
        this.retreatCost = retreatCost;

        this.hp = startingHp;

    }
}
