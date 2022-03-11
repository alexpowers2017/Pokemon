package app.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TypedObjectTest {

    @Test
    void init_givenValidType_assignsType() {
        TypedObject colorless = new TypedObject("colorless");
        Assertions.assertEquals("colorless", colorless.getType());

        TypedObject fire = new TypedObject("fire");
        Assertions.assertEquals("fire", fire.getType());

        TypedObject water = new TypedObject("water");
        Assertions.assertEquals("water", water.getType());

        TypedObject lightning = new TypedObject("lightning");
        Assertions.assertEquals("lightning", lightning.getType());

        TypedObject psychic = new TypedObject("psychic");
        Assertions.assertEquals("psychic", psychic.getType());

        TypedObject fighting = new TypedObject("fighting");
        Assertions.assertEquals("fighting", fighting.getType());

        TypedObject grass = new TypedObject("grass");
        Assertions.assertEquals("grass", grass.getType());
    }

    @Test
    void init_givenNull_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TypedObject nullType = new TypedObject(null);
        });
    }

    @Test
    void init_givenInvalidType_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new TypedObject(""); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new TypedObject("other"); });
    }

    @Test
    void sameType_givenNull_returnsFalse() {
        TypedObject fire = new TypedObject("fire");
        Assertions.assertFalse(fire.sameType(null));
    }

    @Test
    void sameType_givenMatchingType_returnsTrue() {
        TypedObject colorless = new TypedObject("colorless");
        Assertions.assertTrue(colorless.sameType(new TypedObject("colorless")));

        TypedObject fire = new TypedObject("fire");
        Assertions.assertTrue(fire.sameType(new TypedObject("fire")));

        TypedObject water = new TypedObject("water");
        Assertions.assertTrue(water.sameType(new TypedObject("water")));

        TypedObject lightning = new TypedObject("lightning");
        Assertions.assertTrue(lightning.sameType(new TypedObject("lightning")));

        TypedObject psychic = new TypedObject("psychic");
        Assertions.assertTrue(psychic.sameType(new TypedObject("psychic")));

        TypedObject fighting = new TypedObject("fighting");
        Assertions.assertTrue(fighting.sameType(new TypedObject("fighting")));

        TypedObject grass = new TypedObject("grass");
        Assertions.assertTrue(grass.sameType(new TypedObject("grass")));
    }

    @Test
    void sameType_givenNonMatchingType_returnsFalse() {
        TypedObject colorless = new TypedObject("colorless");
        Assertions.assertFalse(colorless.sameType(new TypedObject("fire")));

        TypedObject fire = new TypedObject("fire");
        Assertions.assertFalse(fire.sameType(new TypedObject("water")));

        TypedObject water = new TypedObject("water");
        Assertions.assertFalse(water.sameType(new TypedObject("fighting")));

        TypedObject lightning = new TypedObject("lightning");
        Assertions.assertFalse(lightning.sameType(new TypedObject("colorless")));
    }
}