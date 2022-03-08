package app.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TypeTest {
    @Test
    void init_assignsName() {
        Type type = new Type("water");
        Assertions.assertEquals("water", type.getName());
    }

    @Test
    void init_givenNull_typeIsBlank() {
        Type type = new Type(null);
        Assertions.assertEquals("", type.getName());
    }

    @Test
    void equals_givenBlank_returnsFalse() {
        Type type = new Type("psychic");
        Assertions.assertFalse(type.matches(new Type("")));
    }

    @Test
    void equals_givenMatching_returnsTrue() {
        Type psychic = new Type("psychic");
        Assertions.assertTrue(psychic.matches(new Type("psychic")));

        Type colorless = new Type("colorless");
        Assertions.assertTrue(colorless.matches(new Type("colorless")));
    }

    @Test
    void equals_givenNonMatchingToColorless_returnsFalse() {
        Type colorless = new Type("colorless");
        Assertions.assertFalse(colorless.matches(new Type("fighting")));
    }
}

