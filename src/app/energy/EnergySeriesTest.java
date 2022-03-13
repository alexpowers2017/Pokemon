package app.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class EnergySeriesTest {

    @Test
    void addEnergy() {
        EnergySeries es = new EnergySeries();
        es.add(new Energy("fire"));
        Assertions.assertEquals(1, es.size());
    }

    @Test
    void add() {
        EnergySeries es = new EnergySeries();
        es.add(new Energy("water"));
        es.add(new Energy("fire"));
        Assertions.assertEquals(2, es.size());
    }

    @Test
    void energyRetainsType() {
        EnergySeries es = new EnergySeries();
        es.add(new Energy("water"));
        Energy water = (Energy) es.get(0);
        Assertions.assertTrue(water.equals(new Energy("water")));
    }

    @Test
    void getElements() {
        EnergySeries es = new EnergySeries();
        ArrayList<Object> elements = es.getElements();
    }

    @Test
    void contains() {
        EnergySeries es = new EnergySeries();
        es.add(new Energy("water"));
        Assertions.assertFalse(es.contains(new Energy("fire")));
        Assertions.assertTrue(es.contains(new Energy("water")));
    }
}