package app.cards.energycards;

import app.energy.Energy;
import app.energy.EnergyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnergyCardTest {

    @Test
    void singleInitAssignsName() {
        EnergyCard card = new EnergyCard("fire energy", EnergyBuilder.getEnergy("fire"));
        Assertions.assertEquals("fire", card.getEnergies()[0].getType());
    }

    @Test
    void singleInitCreatesEnergiesArray() {
        EnergyCard card = new EnergyCard("water energy", EnergyBuilder.getEnergy("water"));
        Assertions.assertInstanceOf(Energy[].class, card.getEnergies());
        Assertions.assertEquals(1, card.getEnergies().length);
        Assertions.assertEquals("water", card.getEnergies()[0].getType());
    }

    @Test
    void doubleInit() {
        Energy[] energies = new Energy[]{EnergyBuilder.getEnergy("colorless"), EnergyBuilder.getEnergy("colorless")};
        EnergyCard card = new EnergyCard("double colorless energy", energies);
        Assertions.assertEquals("double colorless energy", card.getName());
        Assertions.assertArrayEquals(energies, card.getEnergies());
    }

}