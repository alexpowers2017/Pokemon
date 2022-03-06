package app.concepts.attacks;

import app.concepts.effects.Effect;
import app.concepts.energy.Energy;
import app.concepts.energy.EnergyBuilder;

import java.util.ArrayList;


public abstract class AttackBuilder {

    public static Energy[] getEnergies(String[] energyNames) {
        ArrayList<Energy> energyList = new ArrayList<>();
        for (String energyName : energyNames) {
            energyList.add(EnergyBuilder.getEnergy(energyName));
        }
        Energy[] energyArray = new Energy[energyList.size()];
        return energyList.toArray(energyArray);
    }

    public static Attack getAttack(String name, String[] energyNames, Integer damage, String description, Effect[] effects) {
        return new Attack(name, getEnergies(energyNames), damage, description, effects);
    }
}
