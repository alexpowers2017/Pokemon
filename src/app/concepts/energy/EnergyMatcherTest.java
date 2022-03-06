package app.concepts.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EnergySatisfiesTest {
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
        assertSatisfies(fireEnergy1, colorlessEnergy1);
        assertSatisfies(psychicEnergy, colorlessEnergy2);
    }
}

class EnergyArraySatisfiesTest {

    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");

    void assertAllSatisfied(Energy[] providedEnergies, Energy[] requiredEnergies) {
        Assertions.assertTrue(EnergyMatcher.allSatisfied(providedEnergies, requiredEnergies));
    }

    void assertNotSatisfied(Energy[] providedEnergies, Energy[] requiredEnergies) {
        Assertions.assertFalse(EnergyMatcher.allSatisfied(providedEnergies, requiredEnergies));
    }

    @Test
    void givenNull_returnsFalse() {
        assertNotSatisfied(new Energy[]{waterEnergy1, waterEnergy2}, null);
        assertNotSatisfied(null, new Energy[]{waterEnergy1, colorlessEnergy1});
    }

    @Test
    void givenEmptyRequired_returnsTrue() {
        assertAllSatisfied(new Energy[]{}, new Energy[]{});
        assertAllSatisfied(new Energy[]{fireEnergy1}, new Energy[]{});
    }

    @Test
    void givenFewerProvidedThanRequired_returnsFalse() {
        assertNotSatisfied(new Energy[]{}, new Energy[]{colorlessEnergy1});
        assertNotSatisfied(new Energy[]{psychicEnergy}, new Energy[]{psychicEnergy, psychicEnergy});
    }

    @Test
    void givenSingleMatchingEnergies_returnsTrue() {
        assertAllSatisfied(new Energy[]{fireEnergy1}, new Energy[]{fireEnergy2});
        assertAllSatisfied(new Energy[]{waterEnergy1}, new Energy[]{waterEnergy2});
        assertAllSatisfied(new Energy[]{colorlessEnergy1}, new Energy[]{colorlessEnergy2});
    }

    @Test
    void givenSingleNonMatchingEnergies_returnsFalse() {
        assertNotSatisfied(new Energy[]{fireEnergy1}, new Energy[]{waterEnergy2});
        assertNotSatisfied(new Energy[]{psychicEnergy}, new Energy[]{fireEnergy2});
    }

    @Test
    void givenSingleColorlessRequiredAnyEnergyProvided_returnsTrue() {
        assertAllSatisfied(new Energy[]{fireEnergy2}, new Energy[]{colorlessEnergy1});
        assertAllSatisfied(new Energy[]{waterEnergy1}, new Energy[]{colorlessEnergy1});
        assertAllSatisfied(new Energy[]{colorlessEnergy2}, new Energy[]{colorlessEnergy1});
        assertAllSatisfied(new Energy[]{psychicEnergy}, new Energy[]{colorlessEnergy1});
    }

    @Test
    void givenTwoNonMatchingEnergies_returnsFalse() {
        assertNotSatisfied(new Energy[]{waterEnergy1, waterEnergy2}, new Energy[]{fireEnergy1, fireEnergy2});
        assertNotSatisfied(new Energy[]{fireEnergy1, colorlessEnergy1}, new Energy[]{psychicEnergy, psychicEnergy});
    }

//    @Test
//    void givenTwoMatchingEnergies_returnsTrue() {
//        assertAllSatisfied(new Energy[]{colorlessEnergy1, psychicEnergy}, new Energy[]{psychicEnergy, colorlessEnergy1});
//        assertAllSatisfied(new Energy[]{psychicEnergy, psychicEnergy}, new Energy[]{psychicEnergy, psychicEnergy});
//        assertAllSatisfied(new Energy[]{waterEnergy1, waterEnergy2}, new Energy[]{waterEnergy1, waterEnergy2});
//        assertAllSatisfied(new Energy[]{colorlessEnergy1, colorlessEnergy2}, new Energy[]{colorlessEnergy1, colorlessEnergy2});
//        assertAllSatisfied(new Energy[]{fireEnergy1, fireEnergy2}, new Energy[]{fireEnergy2, fireEnergy1});
//    }

    @Test
    void getFactorial() {
        Assertions.assertEquals(2, EnergyMatcher.getFactorial(2));
        Assertions.assertEquals(6, EnergyMatcher.getFactorial(3));
        Assertions.assertEquals(24, EnergyMatcher.getFactorial(4));
    }

    @Test
    void getAllCombinations() {
        Assertions.assertArrayEquals(
                new Energy[][]{{psychicEnergy, waterEnergy1}, {waterEnergy1, psychicEnergy}},
                EnergyMatcher.getAllCombinations(new Energy[]{psychicEnergy, waterEnergy1})
        );
        Assertions.assertArrayEquals(
                new Energy[][]{{colorlessEnergy1, fireEnergy1}, {colorlessEnergy1, waterEnergy1}, {fireEnergy1, colorlessEnergy1}, {fireEnergy1, waterEnergy1}, {waterEnergy1, colorlessEnergy1}, {waterEnergy1, fireEnergy1}},
                EnergyMatcher.getAllCombinations(new Energy[]{colorlessEnergy1, fireEnergy1, waterEnergy1})
        );
    }
}