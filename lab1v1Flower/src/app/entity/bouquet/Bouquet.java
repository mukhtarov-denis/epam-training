package app.entity.bouquet;

import java.util.Comparator;
import java.util.List;

import app.entity.flower.Flower;

public interface Bouquet {
    String getDescription();
    double getPrice();
    void addFlower(Flower flower);
    List<Flower> getFlowers();
    void sort(Comparator<Flower> comparator);
}