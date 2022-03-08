package app.energy;

import java.util.ArrayList;
import java.util.Arrays;

public class EnergyMatcher {

    public static boolean allSatisfied(ArrayList<Energy> provided, ArrayList<Energy> required) {
        if (provided == null || required == null || provided.size() < required.size()) {
            return false;
        } else if (required.size() == 0) {
            return true;
        }
        else if (required.size() == 1) {
            for (Energy energy : provided) {
                if (energy.satisfies(required.get(0))) {
                    return true;
                }
            }
        } else {
            ArrayList<ArrayList<Energy>> permutations = PermutationsHelper.getPermutations(required);
            for (ArrayList<Energy> permutation : permutations) {
                ArrayList<Boolean> results = new ArrayList<>();
                for (int i = 0; i < required.size(); i++) {
                    results.add(provided.get(i).satisfies(permutation.get(i)));
                }
                if (!results.contains(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean allSatisfied(Energy[] provided, ArrayList<Energy> required) {
        return allSatisfied(new ArrayList<>(Arrays.asList(provided)), required);
    }

    public static boolean allSatisfied(ArrayList<Energy> provided, Energy[] required) {
        return allSatisfied(provided, new ArrayList<>(Arrays.asList(required)));
    }

    public static boolean allSatisfied(Energy[] provided, Energy[] required) {
        return allSatisfied(new ArrayList<>(Arrays.asList(provided)), new ArrayList<>(Arrays.asList(required)));
    }
}
