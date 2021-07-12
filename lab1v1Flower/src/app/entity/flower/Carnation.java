package app.entity.flower;

import app.entity.flower.type.CarnationType;

public class Carnation extends BaseFlower {

    public Carnation() {
        this.type = new CarnationType();
    }

    @Override
    public double getPrice() {
        return getCost();
    }
}