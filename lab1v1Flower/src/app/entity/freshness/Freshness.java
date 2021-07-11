package app.entity.freshness;

public abstract class Freshness {
    private double value;
    private String name;
    
    protected Freshness(double value, String name) {
        this.value = value;
        this.name = name;
    }
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    FRESH(1),
    MEDIUM_FRESH(0.5),
    NOT_FRESH(0.1);
    */
}