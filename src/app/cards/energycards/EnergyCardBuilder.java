package app.cards.energycards;

import app.concepts.energy.Energy;
import app.concepts.energy.EnergyBuilder;

public abstract class EnergyCardBuilder {
    public static EnergyCard getEnergyCard(String energyType) {
        if (energyType.equals("double colorless")) {
            return new EnergyCard("double colorless energy",  new Energy[]{EnergyBuilder.getEnergy("colorless"), EnergyBuilder.getEnergy("colorless")});
        } else {
            return new EnergyCard(energyType + " energy", EnergyBuilder.getEnergy(energyType));
        }
    }
}
