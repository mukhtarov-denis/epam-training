package by.epam.training.lab3.v1.entity;

public enum Soil {
    PODZOLIC("�����������"),
    GROUND("���������"),
    SOD_PODZOLIC("�������-�����������");
    
    private String description;
    
    private Soil(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}