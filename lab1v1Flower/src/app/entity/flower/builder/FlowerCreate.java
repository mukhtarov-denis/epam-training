package app.entity.flower.builder;

import app.entity.flower.BaseFlower;
import app.entity.flower.type.Type;

public interface FlowerCreate {
    BaseFlower build(Type type);
}