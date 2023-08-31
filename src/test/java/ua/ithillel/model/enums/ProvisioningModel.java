package ua.ithillel.model.enums;

public enum ProvisioningModel {
    REGULAR("Regular"),
    SPOT("Spot (Preemptible VM)");

    private String description;

    ProvisioningModel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
