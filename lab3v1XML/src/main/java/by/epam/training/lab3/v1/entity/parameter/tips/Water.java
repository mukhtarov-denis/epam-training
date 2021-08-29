package by.epam.training.lab3.v1.entity.parameter.tips;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class Water extends AbstractParameter {
    private int intValue;
    
    public Water(String name, String value) {
        super(name, value);
        this.note = "мл. в неделю";
        this.intValue =Integer.parseInt(value); 
    }

    public int getIntValue() {
        return intValue;
    }
    
    @Override
    public String value() {
        return String.valueOf(intValue);
    }
    
    @Override
    public String note() {
        return this.note;
    }
}