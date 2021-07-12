package app.operation.impl;

import java.util.Comparator;

import app.entity.bouquet.Bouquet;
import app.entity.flower.Flower;
import app.operation.Sort;

public class SortImpl implements Sort {

    @Override
    public void sort(Bouquet bouquet, Comparator<Flower> comparator) {
        bouquet.sort(comparator);
    }
}