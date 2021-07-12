package app.entity.flower.builder.impl;

import app.entity.flower.BaseFlower;
import app.entity.flower.Calla;
import app.entity.flower.builder.FlowerCreate;
import app.entity.flower.type.Type;

public class CallaBuilder implements FlowerCreate {
    private CarnationBuilder carnationBuilder;
    
    @Override
    public BaseFlower build(Type type) {
        if (type.getId() == 1) {
            return new Calla();
        } else {
            carnationBuilder = new CarnationBuilder();
            return carnationBuilder.build(type);
        }
    }
}