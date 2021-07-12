package app.entity.flower;

import app.entity.flower.type.Type;
import app.entity.freshness.Freshness;

public abstract class BaseFlower implements Flower {
    protected Type type;
    private double length;
    private double cost;
    private Freshness freshness;

    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        this.length = length;
    }
    
    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public Freshness getFreshness() {
        return freshness;
    }
    
    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
    
    @Override
    public String getDescription() {
        return type.getName() + "(" + length + " m., " + freshness.getName() + ")";
    }
}