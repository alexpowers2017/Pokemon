package app.concepts.attacks;


import app.concepts.energy.Energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class AttackBuilderTest {
    @Test
    void getEnergyArray() {
        String[] names = new String[]{"colorless", "colorless"};
        ArrayList<Energy> energies = AttackBuilder.getEnergies(names);
        Assertions.assertEquals(2, energies.size());
        Assertions.assertInstanceOf(Energy.class, energies.get(0));
        Assertions.assertInstanceOf(Energy.class, energies.get(1));
    }
}