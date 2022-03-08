package app.cards.pokemoncards;

import app.attacks.Attack;
import app.effects.Effect;
import app.energy.Energy;
import app.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class PokemonCardTest {

    Attack tackle = new Attack(
            "tackle",
            new Energy[] {new Energy(new Type("colorless")) },
            10,
            "",
            new Effect[]{}
    );

    PokemonCard voltorb = new PokemonCard(
            "voltorb",
            40,
            new Type("lightning"),
            new Energy[] { new Energy(new Type("colorless"))},
            new Type[] {new Type("fighting")},
            new Type[] {},
            "test description",
            new Attack[] {tackle},
            1
    );

    PokemonCard createPokemonCard(String name, Integer hp, String typeName) {
        return new PokemonCard(
            name,
            hp,
            new Type(typeName),
            new Energy[] {},
            new Type[] {},
            new Type[] {},
            "test description",
            new Attack[] {tackle},
            1
        );
    }

    @Test
    void voltorbInit() {
        Assertions.assertEquals("voltorb", voltorb.getName());
        Assertions.assertEquals(40, voltorb.getStartingHp());
        Assertions.assertEquals("lightning", voltorb.getType().getName());
        Assertions.assertEquals(1, voltorb.getRetreatCost().length);
        Assertions.assertEquals("colorless", voltorb.getRetreatCost()[0].getTypeName());
        Assertions.assertEquals(1, voltorb.getWeaknesses().length);
        Assertions.assertEquals("fighting", voltorb.getWeaknesses()[0].getName());
        Assertions.assertArrayEquals(new Type[0], voltorb.getResistances());
        Assertions.assertEquals("test description", voltorb.getDescription());
        Assertions.assertEquals(1, voltorb.getAttacks().length);
        Assertions.assertEquals("tackle", voltorb.getAttacks()[0].getName());
        Assertions.assertEquals(1, voltorb.getStage());

        Assertions.assertEquals(40, voltorb.getHp());
        Assertions.assertEquals(new ArrayList<>(), voltorb.getEnergyCards());
    }

    @Test
    void sampleInit() {
        PokemonCard sample = createPokemonCard("rattatta", 30, "colorless");
        Assertions.assertEquals("rattatta", sample.getName());
        Assertions.assertEquals(30, sample.getHp());
    }


}