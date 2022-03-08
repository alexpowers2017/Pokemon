package app.energy;

import app.type.TypeBuilder;

public abstract class EnergyBuilder {

    public static Energy getEnergy(String typeName) {
        if (typeName.equals("colorless")) {
            return new ColorlessEnergy(TypeBuilder.getType(typeName));
        } else {
            return new BasicEnergy(TypeBuilder.getType(typeName));
        }
    }
}
