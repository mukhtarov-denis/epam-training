package app.entity.flower;

import app.entity.flower.type.LilyType;

public class Lily extends BaseFlower {

    public Lily() {
        this.type = new LilyType();
    }
    
    @Override
    public double getPrice() {
        return getCost();
    }
}