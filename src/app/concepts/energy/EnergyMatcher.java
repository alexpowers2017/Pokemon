package app.concepts.energy;

import java.util.ArrayList;

public class EnergyMatcher {

    private static Boolean typesMatch(Energy energy1, Energy energy2) {
        return energy1.getTypeName().equals(energy2.getTypeName());
    }

    public static Boolean satisfies(Energy providedEnergy, Energy requiredEnergy) {
        if (providedEnergy == null || requiredEnergy == null) {
            return false;
        } else if (requiredEnergy.getTypeName().equals("colorless")) {
            return true;
        } else {
            return typesMatch(providedEnergy, requiredEnergy);
        }
    }

    public static Boolean allSatisfied(ArrayList<Energy> provided, ArrayList<Energy> required) {
        if (provided == null || required == null || provided.size() < required.size()) {
            return false;
        } else if (required.size() == 0) {
            return true;
        }
        else if (required.size() == 1) {
            for (Energy energy : provided) {
                if (satisfies(energy, required.get(0))) {
                    return true;
                }
            }
        } else {
            ArrayList<ArrayList<Energy>> permutations = getPermutations(required);
            for (ArrayList<Energy> permutation : permutations) {
                ArrayList<Boolean> results = new ArrayList<>();
                for (int i = 0; i < required.size(); i++) {
                    results.add(satisfies(provided.get(i), permutation.get(i)));
                }
                if (!results.contains(false)) {
                    return true;
                }
            }
        }
        return false;
    }

        public static ArrayList<ArrayList<Energy>> getPermutations(ArrayList<Energy> energies) {
            ArrayList<ArrayList<Energy>> permutations = new ArrayList<>();
            permutations.add(energies);
            if (energies.size() == 2) {
                permutations.add(new ArrayList<>() {{add(energies.get(1)); add(energies.get(0)); }});
            } else if (energies.size() == 3) {
                permutations.add(new ArrayList<>() {{add(energies.get(0)); add(energies.get(2)); add(energies.get(1)); }});
                permutations.add(new ArrayList<>() {{add(energies.get(1)); add(energies.get(0)); add(energies.get(2)); }});
                permutations.add(new ArrayList<>() {{add(energies.get(1)); add(energies.get(2)); add(energies.get(0)); }});
                permutations.add(new ArrayList<>() {{add(energies.get(2)); add(energies.get(0)); add(energies.get(1)); }});
                permutations.add(new ArrayList<>() {{add(energies.get(2)); add(energies.get(1)); add(energies.get(0)); }});
            }
            return permutations;
        }
}
