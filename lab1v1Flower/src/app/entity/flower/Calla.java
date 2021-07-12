package app.entity.flower;

import app.entity.flower.type.CallaType;

public class Calla extends BaseFlower {

    public Calla() {
        this.type = new CallaType();
    }

    @Override
    public double getPrice() {
        return getCost();
    }
}