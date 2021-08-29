package by.epam.training.lab3.v1.entity.parameter.tips;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class Light extends AbstractParameter {
    private boolean isLight;
    
    public Light(String name, String value) {
        super(name, value);
        this.isLight = Boolean.parseBoolean(value);
        this.note = "светолюбиво";
    }

    @Override
    public String value() {
        return String.valueOf(isLight);
    }
    
    @Override
    public String note() {
        return this.note;
    }
}