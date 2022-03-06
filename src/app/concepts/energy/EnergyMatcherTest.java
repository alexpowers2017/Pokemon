package app.concepts.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EnergyMatcherTest {
    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");

    void assertSatisfies(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertTrue(EnergyMatcher.satisfies(providedEnergy, requiredEnergy));
    }
    void assertDoesNotSatisfy(Energy providedEnergy, Energy requiredEnergy) {
        Assertions.assertFalse(EnergyMatcher.satisfies(providedEnergy, requiredEnergy));
    }

    @Test
    void givenSameType_satisfiesReturnsTrue() {
        assertSatisfies(waterEnergy1, waterEnergy2);
        assertSatisfies(fireEnergy2, fireEnergy1);
        assertSatisfies(colorlessEnergy1, colorlessEnergy2);
    }

    @Test
    void givenIncorrectType_satisfiesReturnsFalse() {
        assertDoesNotSatisfy(waterEnergy1, fireEnergy2);
        assertDoesNotSatisfy(psychicEnergy, waterEnergy1);
        assertDoesNotSatisfy(colorlessEnergy1, waterEnergy2);
    }

    @Test
    void givenNull_satisfiesReturnsFalse() {
        assertDoesNotSatisfy(null, waterEnergy2);
        assertDoesNotSatisfy(colorlessEnergy1, null);
    }

    @Test
    void givenAnyTypeToColorless_satisfiesReturnsTrue() {
        System.out.println(colorlessEnergy1.getClass());
        assertSatisfies(fireEnergy1, colorlessEnergy1);
        assertSatisfies(psychicEnergy, colorlessEnergy2);
    }
}