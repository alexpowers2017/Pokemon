package app.attacks;

import app.energy.EnergyList;


public class Attack {
    private String name;
    private EnergyList energiesRequired;
    private Integer damage;
    private String description;

    public String getName() {
        return this.name;
    }

    public EnergyList getEnergiesRequired() {
        return this.energiesRequired;
    }

    public Integer getDamage() {
        return this.damage;
    }

    public String getDescription() {
        return this.description;
    }

    public Attack(String name, EnergyList energiesRequired, Integer damage, String description, String name1, EnergyList energiesRequired1, Integer damage1, String description1) {

        this.name = name1;
        this.energiesRequired = energiesRequired1;
        this.damage = damage1;
        this.description = description1;
    }
}

