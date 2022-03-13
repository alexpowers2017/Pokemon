package app.energy;

import java.util.ArrayList;
import java.util.Collection;


public class EnergyList extends ArrayList<Energy> {

    public boolean satisfiedBy(EnergyList energyList) {
        return false;
    }

    public boolean equals(EnergyList energyList) {
        if (energyList == null || this.size() != energyList.size()) {
            return false;
        } else {
            boolean equal = true;
            for (int i = 0; i < this.size(); i++) {
                if (!this.get(i).equals(energyList.get(i))) {
                    equal = false;
                }
            }
            return equal;
        }
    }

    public boolean contains(Energy e) {
        for (Energy energy : this) {
            if (energy.equals(e)) {
                return true;
            }
        }
        return false;
    }

        @Override
        public boolean contains(Object o) {
            Energy e = (Energy) o;
            return this.contains(e);
        }

    public boolean containsAll(EnergyList energyList) {
        for (Energy e : energyList) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

        @Override
        public boolean containsAll(Collection c) {
            EnergyList es = (EnergyList) c;
            return this.containsAll(es);
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

        @Override
        public int indexOf(Object o) {
            Energy e = (Energy) o;
            return this.indexOf(e);
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

        @Override
        public int lastIndexOf(Object o) {
            Energy e = (Energy) o;
            return this.lastIndexOf(e);
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

        @Override
        public boolean remove(Object o) {
            Energy e = (Energy) o;
            return this.remove(e);
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

        @Override
        public boolean removeAll(Collection c) {
            EnergyList es = (EnergyList) c;
            return this.removeAll(es);
        }


}

