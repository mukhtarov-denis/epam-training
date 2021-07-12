package app.filter;

import app.entity.flower.Flower;

public interface Filter {
    boolean check(Flower flower);
}