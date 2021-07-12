package app.comparator;

import java.util.Comparator;

import app.entity.flower.Flower;

public class FreshnessComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower f1, Flower f2) {
        return (int) Math.ceil(f2.getFreshness().getValue() - f1.getFreshness().getValue());
    }
}