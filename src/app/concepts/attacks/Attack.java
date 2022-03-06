package app.concepts.attacks;

import app.concepts.energy.Energy;

public class Attack {
    private Integer damage;
    private Energy[] energiesRequired;
    private String description;

    public Integer getDamage() { return this.damage; }
    public Energy[] getEnergiesRequired() { return this.energiesRequired; }
    public String getDescription() { return this.description; }
}
