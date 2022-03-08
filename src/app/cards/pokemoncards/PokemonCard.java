package app.cards.pokemoncards;

import app.cards.Card;
import app.cards.energycards.EnergyCard;
import app.concepts.attacks.Attack;
import app.concepts.energy.Energy;
import app.concepts.type.Type;

import java.util.ArrayList;


public class PokemonCard extends Card {
    private final Integer startingHp;
    private final Type type;
    private final Energy[] retreatCost;
    private final Type[] weaknesses;
    private final Type[] resistances;
    private final String description;
    private final Attack[] attacks;
    private final Integer stage;

    private Integer hp;
    private ArrayList<EnergyCard> energyCards;

    public Integer getStartingHp() { return this.startingHp; }
    public Type getType() { return this.type; }
    public Energy[] getRetreatCost() { return this.retreatCost; }
    public Type[] getWeaknesses() { return this.weaknesses; }
    public Type[] getResistances() { return this.resistances; }
    public String getDescription() { return this.description; }
    public Attack[] getAttacks() { return this.attacks; }
    public Integer getStage() { return this.stage; }

    public Integer getHp() { return this.hp; }
    public ArrayList<EnergyCard> getEnergyCards() { return this.energyCards; }

    public PokemonCard(String name, Integer startingHp, Type type,
                       Energy[] retreatCost, Type[] weaknesses, Type[] resistances,
                       String description, Attack[] attacks, Integer stage) {
        super(name, "pokemon");
        this.startingHp = startingHp;
        this.type = type;
        this.retreatCost = retreatCost;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.description = description;
        this.attacks = attacks;
        this.stage = stage;

        this.hp = startingHp;
        this.energyCards = new ArrayList<>();
    }
}
