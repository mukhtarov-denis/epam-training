package by.epam.training.lab2.v1.filter;

import by.epam.training.lab2.v1.entity.composite.Component;

public interface Filter {
    boolean check(Component component);
}