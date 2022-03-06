package app.concepts.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TypeBuilderTest {
    private void assertNameMatches(String expectedName, Type type) {
        Assertions.assertEquals(expectedName, type.getName());
    }

    @Test
    void createsCorrectTypeGivenValidString() {
        assertNameMatches("colorless", TypeBuilder.getType("colorless"));
        assertNameMatches("fighting", TypeBuilder.getType("fighting"));
        assertNameMatches("fire", TypeBuilder.getType("fire"));
        assertNameMatches("grass", TypeBuilder.getType("grass"));
        assertNameMatches("lightning", TypeBuilder.getType("lightning"));
        assertNameMatches("psychic", TypeBuilder.getType("psychic"));
        assertNameMatches("water", TypeBuilder.getType("water"));
    }

    @Test
    void givenInvalidType_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TypeBuilder.getType("hello");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TypeBuilder.getType("");
        });
    }

    @Test
    void givenNull_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TypeBuilder.getType(null);
        });
    }
}
