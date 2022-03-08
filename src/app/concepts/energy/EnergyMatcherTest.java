package app.concepts.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


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
        assertSatisfies(fireEnergy1, colorlessEnergy1);
        assertSatisfies(psychicEnergy, colorlessEnergy2);
    }

}

class AllSatisfiedTest {

    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");

    void assertAllSatisfied(ArrayList<Energy> provided, ArrayList<Energy> required) {
        Assertions.assertTrue(EnergyMatcher.allSatisfied(provided, required));
    }

    void assertNotAllSatisfied(ArrayList<Energy> provided, ArrayList<Energy> required) {
        Assertions.assertFalse(EnergyMatcher.allSatisfied(provided, required));
    }

    @Test
    void givenNull_returnsFalse() {
        assertNotAllSatisfied(null, new ArrayList<>() {{
            add(waterEnergy1);
        }});
    }

    @Test
    void givenEmptyArray_returnsFalse() {
        assertNotAllSatisfied(new ArrayList<>(), new ArrayList<>() {{
            add(waterEnergy1);
        }});
    }

    @Test
    void givenSingleMatching_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(fireEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy2);
                }}
        );
    }

    @Test
    void givenEmptyRequired_returnsTrue() {
        assertAllSatisfied(new ArrayList<>(), new ArrayList<>());
        assertAllSatisfied(new ArrayList<>() {{
            add(psychicEnergy);
        }}, new ArrayList<>());
    }

    @Test
    void givenSingleNotMatching_returnsFalse() {
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(psychicEnergy);
                }}
        );
    }

    @Test
    void givenLongerProvidedAllMatching_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy1);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(waterEnergy2);
                }}
        );
    }

    @Test
    void givenLongerProvidedOneMatching_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(waterEnergy2);
                }}
        );
    }

    @Test
    void givenColorlessRequiredAnyProvided_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy2);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                }}
        );
    }

    @Test
    void givenTwoRequiredMatchingTwoProvided_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy1);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(waterEnergy2);
                    add(waterEnergy2);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(fireEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                    add(colorlessEnergy2);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                    add(psychicEnergy);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(psychicEnergy);
                }}
        );
    }

    @Test
    void givenTwoRequiredOppositeMatchingTwoProvided_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy1);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(colorlessEnergy1);
                    add(fireEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy2);
                    add(colorlessEnergy2);
                }}
        );
    }

    @Test
    void givenTwoRequiredOneMatchesBoth_returnsFalse() {
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                }}
        );
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(waterEnergy2);
                }}
        );
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(psychicEnergy);
                }},
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(fireEnergy2);
                }}
        );
    }

    @Test
    void givenThreeRequiredAllMatching_returnsTrue() {
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(waterEnergy1);
                    add(colorlessEnergy2);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                    add(colorlessEnergy1);
                }}
        );
        assertAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(fireEnergy2);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(waterEnergy2);
                    add(psychicEnergy);
                }}
        );
    }

    @Test
    void givenThreeRequiredNotMatching_returnsFalse() {
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(colorlessEnergy2);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                    add(colorlessEnergy1);
                }}
        );
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(waterEnergy2);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(waterEnergy2);
                    add(psychicEnergy);
                }}
        );
    }

    @Test
    void givenThreeRequiredFourNotMatching_returnsFalse() {
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(colorlessEnergy2);
                    add(fireEnergy2);
                    add(colorlessEnergy1);
                }},
                new ArrayList<>() {{
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                    add(colorlessEnergy1);
                }}
        );
        assertNotAllSatisfied(
                new ArrayList<>() {{
                    add(psychicEnergy);
                    add(colorlessEnergy2);
                    add(waterEnergy2);
                    add(waterEnergy1);
                }},
                new ArrayList<>() {{
                    add(fireEnergy1);
                    add(waterEnergy2);
                    add(psychicEnergy);
                }}
        );
    }

}


class GetPermutationsTest {
    Energy waterEnergy1 = EnergyBuilder.getEnergy("water");
    Energy waterEnergy2 = EnergyBuilder.getEnergy("water");
    Energy colorlessEnergy1 = EnergyBuilder.getEnergy("colorless");
    Energy colorlessEnergy2 = EnergyBuilder.getEnergy("colorless");
    Energy fireEnergy1 = EnergyBuilder.getEnergy("fire");
    Energy fireEnergy2 = EnergyBuilder.getEnergy("fire");
    Energy psychicEnergy = EnergyBuilder.getEnergy("psychic");


    @Test
    void getPermutationsLengthOne() {
        ArrayList<Energy> inputs = new ArrayList<>() {{ add(fireEnergy1); }};
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(fireEnergy1); }});
        }};
        Assertions.assertEquals(expected, EnergyMatcher.getPermutations(inputs));
    }

    @Test
    void getPermutationsLengthTwo() {
        ArrayList<Energy> inputs = new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); }};
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); }});
            add(new ArrayList<>() {{ add(waterEnergy1); add(fireEnergy1); }});
        }};
        Assertions.assertEquals(expected, EnergyMatcher.getPermutations(inputs));

        ArrayList<Energy> inputs2 = new ArrayList<>() {{ add(psychicEnergy); add(colorlessEnergy1); }};
        ArrayList<ArrayList<Energy>> expected2 = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(psychicEnergy); add(colorlessEnergy1); }});
            add(new ArrayList<>() {{ add(colorlessEnergy1); add(psychicEnergy); }});
        }};
        Assertions.assertEquals(expected2, EnergyMatcher.getPermutations(inputs2));
    }

    @Test
    void getPermutationsLengthThree() {
        ArrayList<Energy> inputs = new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); add(colorlessEnergy1); }};
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); add(colorlessEnergy1); }});
            add(new ArrayList<>() {{ add(fireEnergy1); add(colorlessEnergy1); add(waterEnergy1); }});
            add(new ArrayList<>() {{ add(waterEnergy1); add(fireEnergy1); add(colorlessEnergy1); }});
            add(new ArrayList<>() {{ add(waterEnergy1); add(colorlessEnergy1); add(fireEnergy1); }});
            add(new ArrayList<>() {{ add(colorlessEnergy1); add(fireEnergy1); add(waterEnergy1); }});
            add(new ArrayList<>() {{ add(colorlessEnergy1); add(waterEnergy1); add(fireEnergy1); }});
        }};
        Assertions.assertEquals(expected, EnergyMatcher.getPermutations(inputs));
    }

}