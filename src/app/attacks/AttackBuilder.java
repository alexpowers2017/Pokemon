package app.attacks;

import app.effects.Effect;
import app.energy.Energy;
import app.energy.EnergyBuilder;


public abstract class AttackBuilder {

    public static Energy[] getEnergies(String[] energyNames) {
        Energy[] energies = new Energy[energyNames.length];
        for (int i = 0; i < energyNames.length; i++) {
            energies[i] = EnergyBuilder.getEnergy(energyNames[i]);
        }
        return energies;
    }

    public static Attack getAttack(String name, Integer damage) {
        return getAttack(name, new String[]{}, damage, "", new Effect[]{});
    }

    public static Attack getAttack(String name, String[] energyNames, Integer damage,
                                   String description, Effect[] effects) {
        return new Attack(name, getEnergies(energyNames), damage, description, effects);
    }

    public static Attack getAttack(String name, String[] energyNames, Integer damage) {
        return getAttack(name, energyNames, damage, "", new Effect[]{});
    }

    public static Attack getAttack(String name, String[] energyNames, Integer damage, String description) {
        return getAttack(name, energyNames, damage, description, new Effect[]{});
    }
}
