package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.Carnation;
import app.entity.flower.builder.FlowerCreate;
import app.entity.flower.type.Type;

public class CarnationBuilder implements FlowerCreate {
    private LilyBuilder lilyBuilder;
    
    @Override
    public BaseFlower build(Type type) {
        if (type.getId() == 2) {
            return new Carnation();
        } else {
            lilyBuilder = new LilyBuilder();
            return lilyBuilder.build(type);
        }
    }
}