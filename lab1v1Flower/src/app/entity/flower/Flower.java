package app.entity.flower;

import app.entity.freshness.Freshness;

public interface Flower {
    String getDescription();
    double getLength();
    double getPrice();
    Freshness getFreshness();
}