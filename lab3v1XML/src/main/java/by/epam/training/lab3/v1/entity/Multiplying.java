package by.epam.training.lab3.v1.entity;

public enum Multiplying {
    LEAF("������"),
    STALK("�������"),
    SEED("������");
    
    private String multiplying;
    
    private Multiplying(String multiplying) {
        this.multiplying = multiplying;
    }
    
    public String getMultiplying() {
        return multiplying;
    }
}