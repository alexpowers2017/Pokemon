package app.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnergyBuilderTest {

    void buildsCorrectly(String typeName) {
        Energy energy = EnergyBuilder.getEnergy(typeName);
        Assertions.assertEquals(typeName, energy.getType());
        Assertions.assertInstanceOf(Energy.class, energy);
    }

    @Test
    void givenValidName_buildEnergy() {
        buildsCorrectly("colorless");
        buildsCorrectly("fighting");
        buildsCorrectly("fire");
        buildsCorrectly("grass");
        buildsCorrectly("lightning");
        buildsCorrectly("psychic");
        buildsCorrectly("water");
    }

    @Test
    void givenColorless_buildColorlessEnergy() {
        Energy colorlessEnergy = EnergyBuilder.getEnergy("colorless");
        Assertions.assertInstanceOf(ColorlessEnergy.class, colorlessEnergy);
    }

    @Test
    void givenInvalidName_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Energy invalidEnergy = EnergyBuilder.getEnergy("fsl");
        });
    }
}