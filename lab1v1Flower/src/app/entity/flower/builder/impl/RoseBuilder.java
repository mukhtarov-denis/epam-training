package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.Rose;
import app.entity.flower.builder.FlowerCreate;
import app.entity.flower.type.Type;

public class RoseBuilder implements FlowerCreate {

    @Override
    public BaseFlower build(Type type) {
        return new Rose();
    }
}