package app.energy;

import java.util.ArrayList;

public class PermutationsHelper {

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
