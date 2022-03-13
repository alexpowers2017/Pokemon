package app.energy;

import app.Series;

import java.util.ArrayList;


public class EnergySeries extends Series {

    public EnergySeries() {
        super();
    }

    public boolean contains(Object o) {
        Energy given = (Energy) o;
        for (Object obj : this.getElements()) {
            Energy element = (Energy) obj;
            if (element.equals(given)) {
                return true;
            }
        }
        return false;
    }

}

