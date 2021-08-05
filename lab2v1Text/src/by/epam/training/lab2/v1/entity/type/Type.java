package by.epam.training.lab2.v1.entity.type;

public abstract class Type {
    private String name;
    
    public Type(String name) {
        this.name = name;
    }
    
    public String getType() {
        return name;
    }
}