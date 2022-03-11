package app.energy;

public abstract class EnergyBuilder {

    public static Energy getEnergy(String typeName) {
        if (typeName.equals("colorless")) {
            return new ColorlessEnergy(typeName);
        } else {
            return new BasicEnergy(typeName);
        }
    }
}
