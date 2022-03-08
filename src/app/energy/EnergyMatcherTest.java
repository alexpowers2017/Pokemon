package app.energy;

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

    @Test
    void givenMatchingArrayProvided_returnsTrue() {
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy},
                new ArrayList<>() {{ add(psychicEnergy);}}
        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{waterEnergy1, waterEnergy1},
                new ArrayList<>() {{ add(waterEnergy2); add(waterEnergy2); }}
        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy, waterEnergy1, fireEnergy1},
                new ArrayList<>() {{ add(colorlessEnergy1); add(psychicEnergy); add(waterEnergy2); }}
        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy, waterEnergy1, fireEnergy1},
                new ArrayList<>() {{ add(colorlessEnergy1); add(waterEnergy2); }}
        ));
    }

    @Test
    void givenMismatchedArrayProvided_returnsFalse() {
        Assertions.assertFalse(EnergyMatcher.allSatisfied(
                new Energy[]{},
                new ArrayList<>() {{ add(psychicEnergy);}}
        ));
        Assertions.assertFalse(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy},
                new ArrayList<>() {{ add(fireEnergy2);}}
        ));
        Assertions.assertFalse(EnergyMatcher.allSatisfied(
                new Energy[]{waterEnergy1, waterEnergy1},
                new ArrayList<>() {{ add(waterEnergy2); add(waterEnergy2); add(colorlessEnergy1); }}
        ));
    }

    @Test
    void givenMatchingArrayRequired_returnTrue() {
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new ArrayList<>() {{ add(psychicEnergy);}},
                new Energy[]{psychicEnergy}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new ArrayList<>() {{ add(waterEnergy2); add(waterEnergy2); }},
                new Energy[]{waterEnergy1, waterEnergy1}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new ArrayList<>() {{ add(fireEnergy2); add(psychicEnergy); add(waterEnergy2); }},
                new Energy[]{psychicEnergy, waterEnergy1, fireEnergy1}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new ArrayList<>() {{ add(psychicEnergy); add(waterEnergy1); add(fireEnergy2); }},
                new Energy[]{waterEnergy1, colorlessEnergy2}
        ));
    }

    @Test
    void givenMatchingArrayRequiredAndProvided_returnTrue() {
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy},
                new Energy[]{psychicEnergy}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{waterEnergy2, waterEnergy2},
                new Energy[]{waterEnergy1, waterEnergy1}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{fireEnergy1, psychicEnergy, waterEnergy1},
                new Energy[]{psychicEnergy, waterEnergy1, fireEnergy1}

        ));
        Assertions.assertTrue(EnergyMatcher.allSatisfied(
                new Energy[]{psychicEnergy, waterEnergy1, fireEnergy2},
                new Energy[]{waterEnergy1, colorlessEnergy2}
        ));
    }

}
