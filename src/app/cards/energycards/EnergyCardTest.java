package app.cards.energycards;

import app.concepts.energy.Energy;
import app.concepts.energy.EnergyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnergyCardTest {

    @Test
    void singleInitAssignsName() {
        EnergyCard card = new EnergyCard("fire energy", EnergyBuilder.getEnergy("fire"));
        Assertions.assertEquals("energy", card.getType());
        Assertions.assertEquals("fire energy", card.getName());
        Assertions.assertEquals("fire", card.getEnergies()[0].getTypeName());
    }

    @Test
    void singleInitCreatesEnergiesArray() {
        EnergyCard card = new EnergyCard("water energy", EnergyBuilder.getEnergy("water"));
        Assertions.assertInstanceOf(Energy[].class, card.getEnergies());
        Assertions.assertEquals(1, card.getEnergies().length);
        Assertions.assertEquals("water", card.getEnergies()[0].getTypeName());
    }

    @Test
    void doubleInit() {
        Energy[] energies = new Energy[]{EnergyBuilder.getEnergy("colorless"), EnergyBuilder.getEnergy("colorless")};
        EnergyCard card = new EnergyCard("double colorless energy", energies);
        Assertions.assertEquals("double colorless energy", card.getName());
        Assertions.assertArrayEquals(energies, card.getEnergies());
    }

}