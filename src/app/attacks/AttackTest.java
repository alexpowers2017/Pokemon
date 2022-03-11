package app.attacks;

import app.effects.Effect;
import app.energy.Energy;
import app.energy.EnergyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class AttackTest {

    Energy colorless = EnergyBuilder.getEnergy("colorless");
    Attack sampleAttack = new Attack(
            "tackle",
            new Energy[]{colorless},
            10,
            "",
            new Effect[]{}
    );

    @Test
    void initAttack() {
        Assertions.assertEquals("tackle", sampleAttack.getName());
        Assertions.assertEquals(colorless, sampleAttack.getEnergiesRequired()[0]);
        Assertions.assertEquals(10, sampleAttack.getDamage());
        Assertions.assertEquals("", sampleAttack.getDescription());
        Assertions.assertArrayEquals(new Effect[]{}, sampleAttack.getEffects());
    }

}
