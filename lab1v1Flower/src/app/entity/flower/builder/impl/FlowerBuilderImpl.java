package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.Flower;
import app.entity.flower.builder.FlowerBuilder;
import app.entity.flower.type.Type;
import app.entity.freshness.Freshness;

public class FlowerBuilderImpl implements FlowerBuilder {
    private Type flowerType;
    private double length;
    private double cost;
    private Freshness freshness;
    
    @Override
    public void setFlowerType(Type flowerType) {
        this.flowerType = flowerType;
    }
    
    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
    
    @Override
    public Flower getResult() {
        BaseFlower baseFlower = new FlowerCreateImpl().build(flowerType);
        baseFlower.setLength(length);
        baseFlower.setCost(cost); 
        baseFlower.setFreshness(freshness);
        return baseFlower;
    }
}