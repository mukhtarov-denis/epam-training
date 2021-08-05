package by.epam.training.lab2.v1.filter.impl;

import by.epam.training.lab2.v1.entity.composite.Component;
import by.epam.training.lab2.v1.entity.type.WordType;
import by.epam.training.lab2.v1.filter.Filter;

public class WordTypeFilter implements Filter{
    
    @Override
    public boolean check(Component component) {
        return component.type().getClass() == WordType.class;
    }
}