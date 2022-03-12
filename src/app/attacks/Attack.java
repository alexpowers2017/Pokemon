package app.attacks;

import app.energy.Energy;


public record Attack(String name, Energy[] energiesRequired, Integer damage, String description) {
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
}

