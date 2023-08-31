package ua.ithillel.model.enums;

public enum MachineFamily {
    GENERAL("General purpose"),
    COMPUTE("Compute-optimized"),
    MEMORY("Memory-optimized"),
    ACCELERATOR("Accelerator Optimized");

    private String description;

    MachineFamily(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
