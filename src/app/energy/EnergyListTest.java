package app.energy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class EnergyListTest {

    EnergyList list;

    Energy getEnergy(String name) {
        return EnergyFactory.build(name);
    }

    void addEnergy(String name) {
        list.add(EnergyFactory.build(name));
    }

    void addEnergy(String name1, String name2) {
        list.add(EnergyFactory.build(name1));
        list.add(EnergyFactory.build(name2));
    }

    void addEnergy(String name1, String name2, String name3) {
        list.add(EnergyFactory.build(name1));
        list.add(EnergyFactory.build(name2));
        list.add(EnergyFactory.build(name3));
    }

    EnergyList getList(String name) {
        EnergyList newList = new EnergyList();
        newList.add(EnergyFactory.build(name));
        return newList;
    }

    EnergyList getList(String name1, String name2) {
        EnergyList newList = new EnergyList();
        newList.add(EnergyFactory.build(name1));
        newList.add(EnergyFactory.build(name2));
        return newList;
    }

    EnergyList getList(String name1, String name2, String name3) {
        EnergyList newList = new EnergyList();
        newList.add(EnergyFactory.build(name1));
        newList.add(EnergyFactory.build(name2));
        newList.add(EnergyFactory.build(name3));
        return newList;
    }

    @BeforeEach
    void setUp() {
        list = new EnergyList();
    }

    @Test
    void init_createsEmptyArrayList() {
        Assertions.assertEquals(new ArrayList<Energy>(), list);
    }

    @Test
    void add() {
        Assertions.assertEquals(0, list.size());
        addEnergy("water");
        Assertions.assertEquals(1, list.size());
        addEnergy("water");
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void addAll() {
        addEnergy("water");
        list.addAll(getList("psychic", "colorless"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertTrue(list.get(0).equals(EnergyFactory.build("water")));
        Assertions.assertTrue(list.get(1).equals(EnergyFactory.build("psychic")));
        Assertions.assertTrue(list.get(2).equals(EnergyFactory.build("colorless")));
    }

    @Test
    void energiesRetainBehaviors() {
        addEnergy("colorless", "fire", "fire");
        Assertions.assertTrue(list.get(1).satisfies(list.get(2)));
        Assertions.assertTrue(list.get(2).equals(list.get(1)));
        Assertions.assertFalse(list.get(2).satisfiedBy(list.get(0)));
        Assertions.assertTrue(list.get(0).satisfiedBy(list.get(1)));
        Assertions.assertTrue(list.get(2).satisfies(list.get(0)));
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(list.isEmpty());
        addEnergy("fire");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        addEnergy("water", "fire");
        Assertions.assertFalse(list.contains(getEnergy("colorless")));
        Assertions.assertTrue(list.contains(getEnergy("water")));
    }

    @Test
    void containsAll_givenNonMatching_returnFalse() {
        addEnergy("psychic", "grass", "fire");
        Assertions.assertFalse(list.containsAll(getList("water", "grass")));
    }

    @Test
    void containsAll_givenMatch_returnsTrue() {
        addEnergy("lightning", "colorless", "water");
        Assertions.assertTrue(list.containsAll(getList("water", "lightning")));
    }

    @Test
    void indexOf() {
        addEnergy("grass", "fighting", "grass");
        Assertions.assertEquals(-1, list.indexOf(getEnergy("psychic")));
        Assertions.assertEquals(1, list.indexOf(getEnergy("fighting")));
        Assertions.assertEquals(0, list.indexOf(getEnergy("grass")));
    }

    @Test
    void lastIndexOf() {
        addEnergy("psychic", "fire", "psychic");
        Assertions.assertEquals(-1, list.lastIndexOf(getEnergy("lightning")));
        Assertions.assertEquals(1, list.lastIndexOf(getEnergy("fire")));
        Assertions.assertEquals(2, list.lastIndexOf(getEnergy("psychic")));
    }

    @Test
    void remove_byIndex_returnsEnergy() {
        addEnergy("psychic");
        Assertions.assertInstanceOf(Energy.class, list.remove(0));
    }

    @Test
    void clear() {
        addEnergy("water", "fire", "lightning");
        Assertions.assertEquals(3, list.size());
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void remove_byObject_matchesType() {
        addEnergy("lightning", "colorless", "lightning");
        Assertions.assertTrue(list.remove(getEnergy("lightning")));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void removeAll() {
        addEnergy("water", "fire", "fire");
        Assertions.assertTrue(list.removeAll(getList("fire", "water")));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void removeAll_failsIfNotAllPresent() {
        addEnergy("water", "psychic", "fire");
        Assertions.assertFalse(list.removeAll(getList("psychic", "lightning")));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void equals_givenNull_returnsFalse() {
        addEnergy("water");
        Assertions.assertFalse(list.equals(null));
    }

    @Test
    void equals_differentLengths_returnsFalse() {
        addEnergy("fire", "water");
        Assertions.assertFalse(list.equals(getList("psychic")));
        Assertions.assertFalse(list.equals(getList("fire", "water", "water")));
    }

    @Test
    void equals_givenMatching_returnsTrue() {
        Assertions.assertTrue(getList("fire").equals(getList("fire")));
        Assertions.assertTrue(getList("water", "psychic").equals(getList("water", "psychic")));
        Assertions.assertTrue(getList("lightning", "fighting", "grass").equals(getList("lightning", "fighting", "grass")));
    }

    @Test
    void satisfiedBy() {
        addEnergy("water");
        Assertions.assertFalse(list.satisfiedBy(getList("psychic")));
        //Assertions.assertTrue(list.satisfiedBy(getList("water")));
    }


}