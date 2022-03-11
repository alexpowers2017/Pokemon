package app.energy;

import app.type.TypedObject;

public class Energy extends TypedObject {

    public Energy(String typeName) {
        super(typeName);
    }

    public boolean satisfiedBy(Energy providedEnergy) {
        return providedEnergy != null && this.sameType(providedEnergy);
    }

    public boolean satisfies(Energy requiredEnergy) {
        return requiredEnergy == null || this.sameType(requiredEnergy);
    }
}


class BasicEnergy extends Energy {
    public BasicEnergy(String typeName) {
        super(typeName);
    }

    @Override
    public boolean satisfies(Energy requiredEnergy) {
        return super.satisfies(requiredEnergy) || requiredEnergy.getType().equals("colorless");
    }
}


class ColorlessEnergy extends Energy {
    public ColorlessEnergy(String typeName) {
        super(typeName);
    }

    @Override
    public boolean satisfiedBy(Energy providedEnergy) {
        return providedEnergy != null;
    }
}


