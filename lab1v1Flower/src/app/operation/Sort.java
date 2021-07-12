package app.operation;

import java.util.Comparator;

import app.entity.bouquet.Bouquet;
import app.entity.flower.Flower;

public interface Sort {
    void sort(Bouquet bouquet, Comparator<Flower> comparator);
}