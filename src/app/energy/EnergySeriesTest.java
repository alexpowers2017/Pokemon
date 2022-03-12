package app.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;


class EnergySeriesTest {

    Energy water = new Energy("water");
    Energy fire = new Energy("fire");
    Energy grass = new Energy("grass");
    Energy psychic = new Energy("psychic");
    Energy colorless = new Energy("colorless");
    Energy lightning = new Energy("lightning");

    EnergySeries emptySeries = new EnergySeries(new ArrayList<>());
    EnergySeries fireSeries = new EnergySeries(new ArrayList<>(){{add(fire);}});
    EnergySeries waterFireSeries = new EnergySeries(new ArrayList<>(){{
        add(water);
        add(fire);
    }});
    EnergySeries psychicGrassColorless = new EnergySeries(new ArrayList<>(){{
        add(psychic);
        add(grass);
        add(colorless);
    }});
    EnergySeries fireWaterLightningGrass = new EnergySeries(new ArrayList<>(){{
        add(fire);
        add(water);
        add(lightning);
        add(grass);
    }});

    @Test
    void init_givenArrayListLengthOne() {
        Assertions.assertEquals("fire", fireSeries.getEnergies().get(0).getType());
    }

    @Test
    void init_givenNull_assignEmptyArrayList() {
        EnergySeries series = new EnergySeries(null);
        Assertions.assertEquals(new ArrayList<Energy>(), series.getEnergies());
    }

    @Test
    void size() {
        Assertions.assertEquals(0, emptySeries.size());
        Assertions.assertEquals(1, fireSeries.size());
        Assertions.assertEquals(2, waterFireSeries.size());
    }

    @Test
    void get_givenValidIndex() {
        Assertions.assertEquals("water", waterFireSeries.get(0).getType());
        Assertions.assertEquals("fire", waterFireSeries.get(1).getType());
    }

    @Test
    void get_givenInvalidIndex_throwsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {fireSeries.get(1);});
    }

    @Test
    void add_addsEnergy() {
        EnergySeries series = new EnergySeries(new ArrayList<>());
        Assertions.assertEquals(0, series.size());
        series.add(new Energy("fire"));
        Assertions.assertEquals(1, series.size());
        Assertions.assertEquals("fire", series.getEnergies().get(0).getType());
    }

    @Test
    void remove_removesEnergy() {
        EnergySeries series = new EnergySeries(new ArrayList<>(){{ add(fire); add(colorless); }});
        Assertions.assertEquals(2, series.size());
        Energy energy = series.remove(0);
        Assertions.assertEquals(1, series.size());
        Assertions.assertEquals(fire, energy);
        Assertions.assertEquals("colorless", series.get(0).getType());
    }

    @Test
    void getPermutations_givenEmpty() {
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{add(new ArrayList<>()); }};
        Assertions.assertEquals(expected, emptySeries.getPermutations());
    }

    @Test
    void getPermutations_lengthOne() {
        EnergySeries series = new EnergySeries(new ArrayList<>() {{ add(water);}});
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(water); }});
        }};
        Assertions.assertEquals(expected, series.getPermutations());
    }

    @Test
    void getPermutations_lengthTwo() {
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(water); add(fire); }});
            add(new ArrayList<>(){{add(fire); add(water); }});
        }};
        Assertions.assertEquals(expected, waterFireSeries.getPermutations());
    }

    @Test
    void getPermutations_lengthThree() {
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{ add(psychic); add(grass); add(colorless); }});
            add(new ArrayList<>(){{ add(psychic); add(colorless); add(grass); }});
            add(new ArrayList<>(){{ add(grass); add(psychic); add(colorless); }});
            add(new ArrayList<>(){{ add(grass); add(colorless); add(psychic); }});
            add(new ArrayList<>(){{ add(colorless); add(psychic); add(grass); }});
            add(new ArrayList<>(){{ add(colorless); add(grass); add(psychic); }});
        }};
        Assertions.assertEquals(expected, psychicGrassColorless.getPermutations());
    }

    @Test
    void getPermutations_lengthFour() {
        ArrayList<ArrayList<Energy>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});

            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});

            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});

            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
            add(new ArrayList<>(){{ add(fire); add(water); add(lightning); add(grass); }});
        }};
        Assertions.assertEquals(expected, fireWaterLightningGrass.getPermutations());
    }

    @Test
    void getIntPermutations_null() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>());
        }};
        Assertions.assertEquals(expected, emptySeries.getIntPermutations(null));
    }

    @Test
    void getIntPermutations_length0() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>());
        }};
        Assertions.assertEquals(expected, emptySeries.getIntPermutations(list));
    }

    @Test
    void getIntPermutations_length1() {
        ArrayList<Integer> list = new ArrayList<>() {{ add(0); }};
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(0); }});
        }};
        Assertions.assertEquals(expected, emptySeries.getIntPermutations(list));
    }

    @Test
    void getIntPermutations_length2() {
        ArrayList<Integer> list1 = new ArrayList<>() {{ add(0); add(1); }};
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(0); add(1); }});
            add(new ArrayList<>() {{ add(1); add(0); }});
        }};
        Assertions.assertEquals(expected, emptySeries.getIntPermutations(list1));
    }

    @Test
    void getIntPermutations_length3() {
        ArrayList<Integer> list1 = new ArrayList<>() {{ add(0); add(1); add(2); }};
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(0); add(1); add(2); }});
            add(new ArrayList<>() {{ add(0); add(2); add(1); }});
            add(new ArrayList<>() {{ add(1); add(0); add(2); }});
            add(new ArrayList<>() {{ add(1); add(2); add(0); }});
            add(new ArrayList<>() {{ add(2); add(0); add(1); }});
            add(new ArrayList<>() {{ add(2); add(1); add(0); }});
        }};
        Assertions.assertEquals(expected, emptySeries.getIntPermutations(list1));
    }


}