package app.concepts.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TypeTest {
    @Test
    void initAssignsName() {
        Type type = new Type("water");
        Assertions.assertEquals("water", type.getName());
    }
}

