package app.concepts.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyBuilderTest {

    void buildsCorrectly(String typeName) {
        Energy energy = EnergyBuilder.getEnergy(typeName);
        Assertions.assertEquals(typeName, energy.getTypeName());
        Assertions.assertEquals(typeName + " energy", energy.getName());
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