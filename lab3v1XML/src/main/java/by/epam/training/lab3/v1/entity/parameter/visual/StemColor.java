package by.epam.training.lab3.v1.entity.parameter.visual;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class StemColor extends AbstractParameter {

    public StemColor(String name, String value) {
        super(name, value);
    }
    
    @Override
    public String value() {
        return value;
    }
}