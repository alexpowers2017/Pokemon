package app.concepts.energy;

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
}
