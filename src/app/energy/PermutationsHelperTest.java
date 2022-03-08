package app.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class PermutationsHelperTest {
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
        Assertions.assertEquals(expected, PermutationsHelper.getPermutations(inputs));
    }

    @Test
    void getPermutationsLengthTwo() {
        ArrayList<Energy> inputs = new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); }};
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(fireEnergy1); add(waterEnergy1); }});
            add(new ArrayList<>() {{ add(waterEnergy1); add(fireEnergy1); }});
        }};
        Assertions.assertEquals(expected, PermutationsHelper.getPermutations(inputs));

        ArrayList<Energy> inputs2 = new ArrayList<>() {{ add(psychicEnergy); add(colorlessEnergy1); }};
        ArrayList<ArrayList<Energy>> expected2 = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(psychicEnergy); add(colorlessEnergy1); }});
            add(new ArrayList<>() {{ add(colorlessEnergy1); add(psychicEnergy); }});
        }};
        Assertions.assertEquals(expected2, PermutationsHelper.getPermutations(inputs2));
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
        Assertions.assertEquals(expected, PermutationsHelper.getPermutations(inputs));
    }

}