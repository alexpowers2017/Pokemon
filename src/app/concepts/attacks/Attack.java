package app.concepts.attacks;

import app.concepts.effects.Effect;
import app.concepts.energy.Energy;

import java.util.ArrayList;

public class Attack {
    private final String name;
    private final ArrayList<Energy> energiesRequired;
    private final Integer damage;
    private final String description;
    private final ArrayList<Effect> effects;

    public String getName() { return this.name; }
    public ArrayList<Energy> getEnergiesRequired() { return this.energiesRequired; }
    public Integer getDamage() { return this.damage; }
    public String getDescription() { return this.description; }
    public ArrayList<Effect> getEffects() { return this.effects; }

    public Attack(String name, ArrayList<Energy> energiesRequired, Integer damage, String description, ArrayList<Effect> effects) {
        this.name = name;
        this.energiesRequired = energiesRequired;
        this.damage = damage;
        this.description = description;
        this.effects = effects;
    }
}
