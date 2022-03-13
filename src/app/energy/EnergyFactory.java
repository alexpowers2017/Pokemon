package app.energy;

public abstract class EnergyFactory {

    public static Energy build(String typeName) {
        if (typeName.equals("colorless")) {
            return new ColorlessEnergy(typeName);
        } else {
            return new BasicEnergy(typeName);
        }
    }
}
