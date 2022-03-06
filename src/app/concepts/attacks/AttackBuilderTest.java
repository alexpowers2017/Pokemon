package app.concepts.attacks;


import app.concepts.energy.Energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AttackBuilderTest {
    @Test
    void getEnergyArray() {
        String[] names = new String[]{"colorless", "colorless"};
        Energy[] energies = AttackBuilder.getEnergies(names);
        Assertions.assertEquals(2, energies.length);
        Assertions.assertInstanceOf(Energy.class, energies[0]);
        Assertions.assertInstanceOf(Energy.class, energies[1]);
    }
}