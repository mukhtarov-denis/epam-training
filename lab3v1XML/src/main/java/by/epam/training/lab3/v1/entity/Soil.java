package by.epam.training.lab3.v1.entity;

public enum Soil {
    PODZOLIC("Подзолистая"),
    GROUND("Грунтовая"),
    SOD_PODZOLIC("Дерново-грунтовая");
    
    private String description;
    
    private Soil(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}