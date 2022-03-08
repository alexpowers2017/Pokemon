package app.type;

public class Type {
    private final String name;
    public String getName() {
        return name;
    }

    public Type(String typeName) {
        if (typeName == null) {
            typeName = "";
        }
        this.name = typeName;
    }

    public boolean matches(Type otherType) {
        return this.getName().equals(otherType.getName());
    }
}
