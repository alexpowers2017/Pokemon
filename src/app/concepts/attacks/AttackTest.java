package app.concepts.attacks;

import app.concepts.energy.Energy;
import app.concepts.energy.EnergyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class AttackTest {

    Energy colorless = EnergyBuilder.getEnergy("colorless");
    Attack sampleAttack = new Attack(
            "tackle",
            new ArrayList<>() {{ add(colorless); }},
            10,
            "",
            new ArrayList<>());

    @Test
    void initAttack() {
        Assertions.assertEquals("tackle", sampleAttack.getName());
        Assertions.assertEquals(colorless, sampleAttack.getEnergiesRequired().get(0));
        Assertions.assertEquals(10, sampleAttack.getDamage());
        Assertions.assertEquals("", sampleAttack.getDescription());
        Assertions.assertEquals(new ArrayList<>(), sampleAttack.getEffects());
    }

    @Test
    void energiesSatisfied() {
        Energy colorless1 = EnergyBuilder.getEnergy("colorless");
        Energy fire = EnergyBuilder.getEnergy("fire");
        Assertions.assertTrue(sampleAttack.energiesSatisfied(new ArrayList<>() {{add(colorless1); }}) );
        Assertions.assertTrue(sampleAttack.energiesSatisfied(new ArrayList<>() {{add(fire); }}) );
    }

}
