package app.cards.pokemoncards;

import app.concepts.type.Type;

public class DamageArbiter {

    public static Integer calculateDamage(Integer damage, PokemonCard attacker, PokemonCard defender) {
        if (defenderIsWeak(attacker, defender)) {
            return damage * 2;
        } else if (defenderIsResistant(attacker, defender)) {
            if (damage < 30) {
                return 0;
            } else {
                return damage - 30;
            }
        } else {
            return damage;
        }
    }

        static boolean defenderIsWeak(PokemonCard attacker, PokemonCard defender) {
            boolean isWeak = false;
            for (Type weakness : defender.getWeaknesses()) {
                if (weakness.getName().equals(attacker.getType().getName())) {
                    isWeak = true;
                    break;
                }
            }
            return isWeak;
        }

        static boolean defenderIsResistant(PokemonCard attacker, PokemonCard defender) {
            boolean isResistant = false;
            for (Type resistance : defender.getResistances()) {
                if (resistance.getName().equals(attacker.getType().getName())) {
                    isResistant = true;
                    break;
                }
            }
            return isResistant;
        }

}
