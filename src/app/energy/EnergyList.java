package app.energy;

import java.util.ArrayList;


public class EnergyList extends ArrayList<Energy> {

    public boolean contains(Energy e) {
        for (Energy energy : this) {
            if (energy.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(EnergyList energyList) {
        EnergyList copy = (EnergyList) this.clone();
        for (Energy e : energyList) {
            if (!copy.contains(e)) {
                return false;
            } else {
                copy.remove(e);
            }
        }
        return true;
    }

    public int indexOf(Energy e) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(Energy e) {
        int index = -1;
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.get(i).equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(Energy e) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(e)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(EnergyList energyList) {
        if (!this.containsAll(energyList)) {
            return false;
        } else {
            int startingSize = this.size();
            for (Energy e : energyList) {
                this.remove(e);
            }
            return startingSize > this.size();
        }
    }
}

