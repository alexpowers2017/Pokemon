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

    public static Boolean allSatisfied (Energy[] providedEnergies, Energy[] requiredEnergies) {
        if (providedEnergies == null || requiredEnergies == null || providedEnergies.length < requiredEnergies.length) {
            return false;
        } else if (requiredEnergies.length == 0) {
            return true;
        } else if (requiredEnergies.length == 1) {
            for (Energy provided : providedEnergies) {
                if (satisfies(provided, requiredEnergies[0])) {
                    return true;
                }
            }
        } else {
            ArrayList<ArrayList<Boolean>> allResults;
            for (Energy provided : providedEnergies) {
                ArrayList<Energy[]> allRequiredCombinations = new ArrayList<>();
                for (Energy required : requiredEnergies) {
                    allRequiredCombinations.add(new Energy[]{provided, required});
                }
//                for (Energy[] combination : allRequiredCombinations) {
//                    System.out.println(combination[0].getTypeName() + " : " + combination[1].getTypeName());
//                }
//                System.out.println("-------------------");
            }
//            for (Energy[] combination : allCombinations) {
//                System.out.println(combination[0].getTypeName() + " : " + combination[1].getTypeName());
//            }
        }
        return false;
    }

    public static int getFactorial(Integer n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (i + 1);
        }
        return result;
    }

    public static Energy[][] getAllCombinations(Energy[] energies) {
        int combinationsCount = getFactorial(energies.length);
        ArrayList<Energy[]> combinationsList = new ArrayList<>();
        for (int i = 0; i < energies.length; i++) {
            for (int j = 0; j < energies.length; j++) {
                if (i != j) {
                    combinationsList.add(new Energy[]{energies[i], energies[j]});
                }
            }
        }
        Energy[][] combinations = new Energy[combinationsCount][2];
        return combinationsList.toArray(combinations);
    }
}
