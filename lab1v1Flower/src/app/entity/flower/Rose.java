package app.entity.flower;

import app.entity.flower.type.RoseType;

public class Rose extends BaseFlower {

    public Rose() {
        this.type = new RoseType();
    }
    
    @Override
    public double getPrice() {
        return getCost() - (1 - getLength()) * getCost();
    }
}