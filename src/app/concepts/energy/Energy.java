package app.concepts.energy;

import app.concepts.type.Type;

public class Energy {
    private final Type type;

    public Type getType() { return this.type; }
    public String getTypeName() { return this.type.getName(); }
    public String getName() { return this.getTypeName() + " energy"; }

    public Energy(Type energyType) {
        this.type = energyType;
    }

    public Boolean isSatisfiedBy(Energy otherEnergy) {
        if (otherEnergy == null) { return false; }
        return this.getTypeName().equals(otherEnergy.getTypeName());
    }
}


class BasicEnergy extends Energy {
    public BasicEnergy(Type energyType) {
        super(energyType);
    }
}


class ColorlessEnergy extends Energy {
    public ColorlessEnergy(Type energyType) {
        super(energyType);
    }

    @Override
    public Boolean isSatisfiedBy(Energy otherEnergy) {
        return otherEnergy != null;
    }
}


