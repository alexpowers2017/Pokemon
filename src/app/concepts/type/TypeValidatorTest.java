package app.concepts.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeValidatorTest {

    TypeValidator typeValidator = new TypeValidator();

    void assertValid(String typeString) {
        Assertions.assertTrue(typeValidator.isValidType(typeString));
    }

    void assertInvalid(String typeString) {
        Assertions.assertFalse(typeValidator.isValidType(typeString));
    }

    @Test
    void givenValidType_returnsTrue() {
        assertValid("colorless");
        assertValid("fighting");
        assertValid("fire");
        assertValid("grass");
        assertValid("lightning");
        assertValid("psychic");
        assertValid("water");
    }

    @Test
    void givenInvalidType_returnsFalse() {
        assertInvalid("wrong type");
        assertInvalid("hello");
        assertInvalid(" psychic");
    }

    @Test
    void givenNull_returnsFalse() {
        assertInvalid(null);
    }

}