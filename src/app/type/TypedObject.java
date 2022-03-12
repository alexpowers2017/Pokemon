package app.type;

import java.util.List;

public class TypedObject {
    private final String type;
    public String getType() {
        return type;
    }

    public TypedObject(String type) {
        List<String> validTypes = List.of("colorless", "fire", "fighting", "grass", "lightning", "psychic", "water");
        if (type == null || !validTypes.contains(type)) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = type;
    }

    public boolean equals(TypedObject provided) {
        return provided != null && this.getType().equals(provided.getType());
    }


}


