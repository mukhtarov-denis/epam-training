package app.entity.flower.builder;

import app.entity.flower.Flower;
import app.entity.flower.type.Type;
import app.entity.freshness.Freshness;

public interface FlowerBuilder {
    void setFlowerType(Type type);
    void setLength(double length);
    void setCost(double cost);
    void setFreshness(Freshness freshness);
    Flower getResult();
}