package app.energy;

import java.util.ArrayList;
import java.util.Objects;

public class EnergySeries {

    private final ArrayList<Energy> energies;
    public ArrayList<Energy> getEnergies() { return this.energies; }

    public EnergySeries(ArrayList<Energy> energies) {
        this.energies = Objects.requireNonNullElseGet(energies, ArrayList::new);
    }

    public int size() {
        return this.energies.size();
    }

    public Energy get(int index) {
        return this.energies.get(index);
    }

    public void add(Energy energy) {
        this.energies.add(energy);
    }

    public Energy remove(int index) {
        return this.energies.remove(index);
    }

    public ArrayList<ArrayList<Energy>> getPermutations() {
        ArrayList<ArrayList<Energy>> permutations = new ArrayList<>();
        if (this.energies.size() == 0) {
            permutations.add(new ArrayList<>());
        } else {
            ArrayList<Integer> indices = getIndices(this.energies);
            for (ArrayList<Integer> permutation : getIntPermutations(indices)) {
                ArrayList<Energy> energyPermutation = new ArrayList<>();
                for (Integer index : permutation) {
                    energyPermutation.add(this.energies.get(index));
                }
                permutations.add(energyPermutation);
            }
        }
        return permutations;
    }

        private ArrayList<Integer> getIndices(ArrayList<Energy> energies) {
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < energies.size(); i++) {
                indices.add(i);
            }
            return indices;
        }

        public ArrayList<ArrayList<Integer>> getIntPermutations(ArrayList<Integer> integers) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (integers == null || integers.size() == 0) {
                result.add(new ArrayList<>());
                return result;
            } else if (integers.size() == 1) {
                result.add(integers);
                return result;
            } else {
                for (int i = 0; i < integers.size(); i++) {
                    Chunk chunk = new Chunk(integers, i);
                    ArrayList<ArrayList<Integer>> allPermutations = chunk.addAllSteps();
                    result.addAll(allPermutations);
                }
                return result;
            }
        }
}

class Chunk {
    public ArrayList<Integer> integers;
    public ArrayList<ArrayList<Integer>> permutations;

    public Chunk(ArrayList<Integer> integers, int firstIndex) {
        ArrayList<Integer> copy = new ArrayList<>(integers);
        Integer first = copy.remove(firstIndex);
        this.integers = copy;
        this.permutations = new ArrayList<>();
        for (Integer integer : copy) {
            this.permutations.add( new ArrayList<>() {{ add(first); add(integer);}});
        }
    }

    public void addStep() {
        ArrayList<ArrayList<Integer>> newPermutations = new ArrayList<>();
        for (ArrayList<Integer> permutation : permutations) {
            ArrayList<Integer> remaining = new ArrayList<>();
            for (Integer n : this.integers) {
                if (!permutation.contains(n)) { remaining.add(n); }
            }
            for (Integer r : remaining) {
                ArrayList<Integer> copy = new ArrayList<>(permutation);
                copy.add(r);
                newPermutations.add(copy);
            }
        }
        this.permutations = newPermutations;
    }

    public ArrayList<ArrayList<Integer>> addAllSteps() {
        while (this.permutations.get(0).size() <= this.integers.size()) {
            this.addStep();
        }
        return this.permutations;
    }
}


