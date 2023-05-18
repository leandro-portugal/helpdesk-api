package tech.leandroportugal.helpdesk.domain.enums;

public enum Priority {
    
        
    LOW("baixa", "LOW"),
    MEDIUN("media", "MEDIUN"),
    HIGH("alta", "HIGH");

    private String name;
    private String description;

    private Priority(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(String priorityName) {
        if (priorityName == null) {
            return null;
        }
        for (Priority x : Priority.values()) {
            if (priorityName.equals(x.getName())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida");

    }
}
