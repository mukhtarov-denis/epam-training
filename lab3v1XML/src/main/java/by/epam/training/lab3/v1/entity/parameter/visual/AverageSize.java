package by.epam.training.lab3.v1.entity.parameter.visual;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class AverageSize extends AbstractParameter {
    private int intValue;
    
    public AverageSize(String name, String value) {
        super(name, value);
        intValue = Integer.parseInt(value);
    }

    @Override
    public String value() {
        return String.valueOf(intValue);
    }
}