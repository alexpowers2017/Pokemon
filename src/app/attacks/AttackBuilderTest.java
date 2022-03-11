package app.attacks;


import app.effects.Effect;
import app.energy.Energy;

import app.energy.EnergyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AttackBuilderTest {


    void assertAttacksEqual(Attack expected, Attack input) {
        Assertions.assertEquals(expected.getName(), input.getName());
        Assertions.assertTrue(energyArraysEqual(expected.getEnergiesRequired(), input.getEnergiesRequired()));
        Assertions.assertEquals(expected.getDamage(), input.getDamage());
        Assertions.assertEquals(expected.getDescription(), input.getDescription());
        Assertions.assertArrayEquals(expected.getEffects(), input.getEffects());
    }

        boolean energyArraysEqual(Energy[] expected, Energy[] input) {
            if (expected.length != input.length) { return false; }
            for (int i = 0; i < expected.length; i++) {
                if (!expected[i].getType().matches(input[i].getType())) { return false; }
            }
            return true;
        }

    @Test
    void getEnergies() {
        String[] names = new String[]{"colorless", "colorless"};
        Energy[] energies = AttackBuilder.getEnergies(names);
        Assertions.assertEquals(2, energies.length);
        Assertions.assertInstanceOf(Energy.class, energies[0]);
        Assertions.assertInstanceOf(Energy.class, energies[1]);
    }

    @Test
    void getAttack_givenNameAndDamage() {
        Attack expected = new Attack("name", new Energy[]{}, 20, "", new Effect[]{});
        assertAttacksEqual(expected, AttackBuilder.getAttack("name", 20));
    }

    @Test
    void getAttack_givenNameDamageAndEnergyNames() {
        Attack expected = new Attack("name", new Energy[]{EnergyBuilder.getEnergy("fire")}, 30, "", new Effect[]{});
        assertAttacksEqual(expected, AttackBuilder.getAttack("name", new String[]{"fire"}, 30));

        Attack expected2 = new Attack("name2",
                new Energy[]{EnergyBuilder.getEnergy("fire"), EnergyBuilder.getEnergy("colorless")},
                20,
                "",
                new Effect[]{}
        );
        assertAttacksEqual(expected2, AttackBuilder.getAttack("name2", new String[]{"fire", "colorless"}, 20));
    }

    @Test
    void getAttack_givenNameDamageEnergyAndDescription() {
        Attack expected = new Attack("tackle",
                new Energy[]{EnergyBuilder.getEnergy("colorless"), EnergyBuilder.getEnergy("psychic")},
                10,
                "Do an tackel",
                new Effect[]{}
        );
        assertAttacksEqual(
            expected,
            AttackBuilder.getAttack("tackle", new String[]{"colorless", "psychic"}, 10, "Do an tackel")
        );
    }

}