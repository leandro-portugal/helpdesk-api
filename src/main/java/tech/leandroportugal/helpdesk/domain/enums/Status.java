package tech.leandroportugal.helpdesk.domain.enums;

public enum Status {
    
    OPEN("open", "OPEN"),
    PROGRESS("progress", "PROGRESS"),
    CLOSE("close", "CLOSE");

    private String name;
    private String description;

    private Status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(String statusName) {
        if (statusName == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (statusName.equals(x.getName())) {
                return x;

            }
        }
        throw new IllegalArgumentException("Status inválido");
    }

}
