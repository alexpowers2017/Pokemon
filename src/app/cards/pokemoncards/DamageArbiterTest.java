package app.cards.pokemoncards;

import app.concepts.attacks.Attack;
import app.concepts.energy.Energy;
import app.concepts.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageArbiterTest {

    PokemonCard createPokemonCard(String name, Integer hp, String typeName, String weakness, String resistance) {
        return new PokemonCard(
                name,
                hp,
                new Type(typeName),
                new Energy[] {},
                new Type[] {new Type(weakness)},
                new Type[] {new Type(resistance)},
                "test description",
                new Attack[] {},
                1
        );
    }

    PokemonCard card1 = createPokemonCard("voltorb", 50, "lightning", "fighting", "water");
    PokemonCard card2 = createPokemonCard("machop", 50, "fighting", "psychic", "colorless");
    PokemonCard card3 = createPokemonCard("machop", 50, "water", "lightning", "colorless");

    @Test
    void givenNoWeaknesses_returnDamage() {
        Assertions.assertEquals(40, DamageArbiter.calculateDamage(40, card1, card2));
        Assertions.assertEquals(10, DamageArbiter.calculateDamage(10, card3, card2));
    }

    @Test
    void givenWeakness_returnDoubleDamage() {
        Assertions.assertEquals(60, DamageArbiter.calculateDamage(30, card2, card1));
        Assertions.assertEquals(40, DamageArbiter.calculateDamage(20, card1, card3));
    }

    @Test
    void givenResistance_returnDamageMinus30() {
        Assertions.assertEquals(10, DamageArbiter.calculateDamage(40, card3, card1));
    }

    @Test
    void givenResistanceAndDamageLowerThan30_returnDamageMinus30() {
        Assertions.assertEquals(0, DamageArbiter.calculateDamage(30, card3, card1));
        Assertions.assertEquals(0, DamageArbiter.calculateDamage(10, card3, card1));
    }


}