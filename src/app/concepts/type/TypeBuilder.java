package app.concepts.type;

public abstract class TypeBuilder {

    public static Type getType(String typeName) {
        TypeValidator typeValidator = new TypeValidator();
        if (typeValidator.isValidType(typeName)) {
            return new Type(typeName);
        }
        else {
            throw new IllegalArgumentException("Invalid type: " + typeName);
        }
    }
}
