package app.concepts.attacks;

import app.concepts.effects.Effect;
import app.concepts.energy.Energy;

public class Attack {
    private final String name;
    private final Energy[] energiesRequired;
    private final Integer damage;
    private final String description;
    private final Effect[] effects;

    public String getName() { return this.name; }
    public Energy[] getEnergiesRequired() { return this.energiesRequired; }
    public Integer getDamage() { return this.damage; }
    public String getDescription() { return this.description; }
    public Effect[] getEffects() { return this.effects; }

    public Attack(String name, Energy[] energiesRequired, Integer damage, String description, Effect[] effects) {
        this.name = name;
        this.energiesRequired = energiesRequired;
        this.damage = damage;
        this.description = description;
        this.effects = effects;
    }
}
