package app.attacks;

import app.effects.Effect;
import app.energy.Energy;

import java.util.ArrayList;


public record Attack(String name, Energy[] energiesRequired, Integer damage,
                     String description, Effect[] effects) {
    public String getName() {
        return this.name;
    }

    public Energy[] getEnergiesRequired() {
        return this.energiesRequired;
    }

    public Integer getDamage() {
        return this.damage;
    }

    public String getDescription() {
        return this.description;
    }

    public Effect[] getEffects() {
        return this.effects;
    }

}

