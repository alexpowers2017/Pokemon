package app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SeriesTest {

    @Test
    void init_createEmptyList() {
        Series series = new Series();
        Assertions.assertNotEquals(null, series.getElements());
        Assertions.assertEquals(0, series.getElements().size());
    }

    @Test
    void add() {
        Series series = new Series();
        series.add(3);
        Assertions.assertEquals(1, series.getElements().size());
        Assertions.assertTrue(series.add("hello"));
        Assertions.assertEquals(2, series.getElements().size());
    }

    @Test
    void add_atIndex_validIndex() {
        Series series = new Series();
        series.add("added first");
        series.add(0, "added second");
        Assertions.assertEquals("added second", series.get(0));
        Assertions.assertEquals("added first", series.get(1));
    }

    @Test
    void add_atIndex_indexTooBig() {
        Series series = new Series();
        series.add("hi");
        series.add(2, "element");
        Assertions.assertEquals("element", series.get(1));
        Assertions.assertEquals("hi", series.get(0));
    }

    @Test
    void add_atIndex_indexTooSmall() {
        Series series = new Series();
        series.add("added first");
        series.add(-1, "added second");
        Assertions.assertEquals("added second", series.get(0));
        Assertions.assertEquals("added first", series.get(1));
    }

    @Test
    void size() {
        Series series = new Series();
        Assertions.assertEquals(0, series.size());
        series.add(4.3);
        Assertions.assertEquals(1, series.size());
    }

    @Test
    void isEmpty() {
        Series series = new Series();
        Assertions.assertTrue(series.isEmpty());
        series.add("who");
        Assertions.assertFalse(series.isEmpty());
    }

    @Test
    void get() {
        Series series = new Series();
        series.add(1);
        series.add("hi");
        Assertions.assertEquals(1, series.get(0));
        Assertions.assertEquals("hi", series.get(1));
    }

    @Test
    void clear() {
        Series series = new Series();
        series.add(1);
        series.add(2);
        Assertions.assertEquals(2, series.size());
        series.clear();
        Assertions.assertEquals(0, series.size());
    }

    @Test
    void indexOf() {
        Series series = new Series();
        series.add("two");
        series.add("one");
        series.add("one");
        Assertions.assertEquals(-1, series.indexOf("three"));
        Assertions.assertEquals(1, series.indexOf("one"));
    }

    @Test
    void lastIndexOf() {
        Series series = new Series();
        series.add("two");
        series.add("one");
        series.add("one");
        Assertions.assertEquals(-1, series.lastIndexOf("three"));
        Assertions.assertEquals(2, series.lastIndexOf("one"));
    }

    @Test
    void contains() {
        Series series = new Series();
        series.add(1);
        series.add(2);
        Assertions.assertFalse(series.contains(3));
        Assertions.assertTrue(series.contains(1));
    }

    @Test
    void remove() {
        Series series = new Series();
        series.add("one");
        series.add("two");
        Assertions.assertEquals("one", series.remove(0));
        Assertions.assertEquals(1, series.size());
        Assertions.assertEquals("two", series.get(0));
    }

    @Test
    void remove_byObject() {
        Series series = new Series();
        series.add("one");
        series.add("one");
        series.add("two");
        Assertions.assertFalse(series.remove("three"));
        Assertions.assertTrue(series.remove("one"));
        Assertions.assertEquals(2, series.size());
        Assertions.assertEquals("one", series.get(0));
        Assertions.assertEquals("two", series.get(1));
    }

    @Test
    void addAll() {
        Series series = new Series();
        ArrayList<String> strings = new ArrayList<>() {{ add("one"); add("two"); add("three"); }};
        series.addAll(strings);
        Assertions.assertEquals(strings, series.getElements());
        series.addAll(2, new ArrayList<>() {{ add("five"); add("seven"); }});
        Assertions.assertEquals(new ArrayList<>() {{ add("one"); add("two"); add("five"); add("seven"); add("three"); }}, series.getElements());
    }

    @Test
    void containsAll() {
        Series series = new Series();
        series.addAll(List.of(new Integer[]{1, 2, 3}));
        Assertions.assertFalse(series.containsAll(List.of(new Integer[]{2, 3, 4})));
        Assertions.assertTrue(series.containsAll(List.of(new Integer[]{2})));
        Assertions.assertTrue(series.containsAll(List.of(new Integer[]{1, 3})));
        Assertions.assertTrue(series.containsAll(List.of(new Integer[]{2, 1, 3})));
    }

    @Test
    void removeAll() {
        Series series = new Series();
        series.addAll(List.of(new String[]{"one", "one", "two", "three"}));
        Assertions.assertFalse(series.removeAll(List.of(new String[]{"four", "five"})));
        Assertions.assertTrue(series.removeAll(List.of(new String[]{"one", "two"})));
        Assertions.assertEquals(new ArrayList<String>() {{ add("one"); add("three"); }}, series.getElements());
        Assertions.assertTrue(series.removeAll(List.of(new String[]{"one", "seven"})));
        Assertions.assertEquals(new ArrayList<String>() {{ add("three"); }}, series.getElements());
    }



}