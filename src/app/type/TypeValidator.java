package app.type;

public class TypeValidator {
    private final String[] validTypes = new String[]{
            "colorless",
            "fighting",
            "fire",
            "grass",
            "lightning",
            "psychic",
            "water"
    };

    public Boolean isValidType(String proposedType) {
        if (proposedType != null) {
            for (String validType : validTypes) {
                if (proposedType.equals(validType)) {
                    return true;
                }
            }
        }
        return false;
    }
}
