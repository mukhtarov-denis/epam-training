package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.builder.FlowerCreate;
import app.entity.flower.type.Type;

public class FlowerCreateImpl implements FlowerCreate {
    private CallaBuilder callaBuilder;
    
    @Override
    public BaseFlower build(Type type) {
        callaBuilder = new CallaBuilder();
        return callaBuilder.build(type);
    }
}