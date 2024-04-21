package org.example.task.facade.material.model;

public class MaterialResponseModel {
    private Long id;
    private String type;
    private int maxCapacity;
    private String displayName;
    private String description;
    private String icon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Material: " + displayName + '\n' +
                "ID: " + id + '\n' +
                "MaxCapacity: " + maxCapacity + '\n' +
                "Type: " + type + '\n' +
                "Description: " + description + '\n' +
                "Icon: " + icon + '\n';
    }
}
