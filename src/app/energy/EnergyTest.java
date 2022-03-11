package app.energy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SatisfiesTest {
    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");
    Energy lightningEnergy = EnergyBuilder.getEnergy("lightning");

    void assertSatisfies(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertTrue(providedEnergy.satisfies(requiredEnergy));
    }

    void assertDoesNotSatisfy(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertFalse(providedEnergy.satisfies(requiredEnergy));
    }

    @Test
    void givenNull_returnsTrue() {
        assertSatisfies(waterEnergy1, null);
        assertSatisfies(colorlessEnergy1, null);
    }

    @Test
    void givenMatch_returnsTrue() {
        assertSatisfies(waterEnergy1, waterEnergy2);
        assertSatisfies(fireEnergy2, fireEnergy1);
        assertSatisfies(colorlessEnergy1, colorlessEnergy2);
    }

    @Test
    void givenMismatch_returnsFalse() {
        assertDoesNotSatisfy(psychicEnergy, fireEnergy1);
        assertDoesNotSatisfy(fireEnergy2, waterEnergy1);
    }

    @Test
    void givenColorlessRequired_anyTypeReturnsTrue() {
        assertSatisfies(fireEnergy1, colorlessEnergy2);
        assertSatisfies(psychicEnergy, colorlessEnergy1);
        assertSatisfies(lightningEnergy, colorlessEnergy1);
        assertSatisfies(waterEnergy2, colorlessEnergy2);
    }
}

class SatisfiedByTest {
    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");
    Energy lightningEnergy = EnergyBuilder.getEnergy("lightning");

    void assertSatisfiedBy(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertTrue(requiredEnergy.satisfiedBy(providedEnergy));
    }

    void assertNotSatisfiedBy(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertFalse(requiredEnergy.satisfiedBy(providedEnergy));
    }

    @Test
    void givenNullProvided_returnsFalse() {
        assertNotSatisfiedBy(null, waterEnergy1);
        assertNotSatisfiedBy(null, lightningEnergy);
        assertNotSatisfiedBy(null, colorlessEnergy2);
    }

    @Test
    void givenMatch_returnsTrue() {
        assertSatisfiedBy(waterEnergy1, waterEnergy2);
        assertSatisfiedBy(fireEnergy2, fireEnergy1);
        assertSatisfiedBy(colorlessEnergy1, colorlessEnergy2);
    }

    @Test
    void givenMismatch_returnsFalse() {
        assertNotSatisfiedBy(psychicEnergy, fireEnergy1);
        assertNotSatisfiedBy(fireEnergy2, waterEnergy1);
        assertNotSatisfiedBy(waterEnergy2, lightningEnergy);
    }

    @Test
    void givenAnyTypeToColorless_returnsFalse() {
        assertSatisfiedBy(fireEnergy1, colorlessEnergy2);
        assertSatisfiedBy(waterEnergy2, colorlessEnergy2);
        assertSatisfiedBy(psychicEnergy, colorlessEnergy2);
        assertSatisfiedBy(lightningEnergy, colorlessEnergy2);
    }
}

