package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.Lily;
import app.entity.flower.builder.FlowerCreate;
import app.entity.flower.type.Type;

public class LilyBuilder implements FlowerCreate {
    private RoseBuilder roseBuilder;
    
    @Override
    public BaseFlower build(Type type) {
        if (type.getId() == 3) {
            return new Lily();
        } else {
            roseBuilder = new RoseBuilder();
            return roseBuilder.build(type);
        }
    }
}