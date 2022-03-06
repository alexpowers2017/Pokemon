package app.concepts.energy;

import app.concepts.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EnergyTest {
    @Test
    void getName() {
        Energy fireEnergy = new Energy(new Type("fire"));
        Assertions.assertEquals("fire energy", fireEnergy.getName());
    }

    @Test
    void getTypeName() {
        Energy waterEnergy = new Energy(new Type("water"));
        Assertions.assertEquals("water", waterEnergy.getTypeName());
    }
}

