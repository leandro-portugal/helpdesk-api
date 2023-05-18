package tech.leandroportugal.helpdesk.domain.enums;

public enum Profile {
    
    ADMIN("admin", "ROLE_ADMIN"),
    TECHNICAL("technical", "ROLE_TECHNICAL"),
    CUSTOMER("customer", "ROLE_CUSTOMER");

    private String name;
    private String description;

    private Profile(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(String profileName) {
        if (profileName == null) {
            return null;
        }
        for (Profile x : Profile.values()) {
            if (profileName.equals(x.getName())) {
                return x;

            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }

}
