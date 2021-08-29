package by.epam.training.lab3.v1.entity.parameter.tips;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class Temperature extends AbstractParameter {
    private int temperature;
    
    public Temperature(String name, String value) {
        super(name, value);
        temperature = Integer.parseInt(value);
    }
    
    @Override
    public String value() {
        return String.valueOf(temperature);
    }
}