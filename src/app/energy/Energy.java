package app.energy;

import app.type.Type;

public class Energy {
    private final Type type;

    public Type getType() { return this.type; }
    public String getTypeName() { return this.type.getName(); }
    public String getName() { return this.type.getName() + " energy"; }

    public Energy(Type energyType) {
        this.type = energyType;
    }

    public boolean satisfiedBy(Energy providedEnergy) {
        return providedEnergy != null && this.getType().matches(providedEnergy.getType());
    }

    public boolean satisfies(Energy requiredEnergy) {
        return requiredEnergy == null || this.type.matches(requiredEnergy.getType());
    }
}


class BasicEnergy extends Energy {
    public BasicEnergy(Type energyType) {
        super(energyType);
    }

    @Override
    public boolean satisfies(Energy requiredEnergy) {
        return super.satisfies(requiredEnergy) || requiredEnergy.getTypeName().equals("colorless");
    }
}


class ColorlessEnergy extends Energy {
    public ColorlessEnergy(Type energyType) {
        super(energyType);
    }

    @Override
    public boolean satisfiedBy(Energy providedEnergy) {
        return providedEnergy != null;
    }
}


