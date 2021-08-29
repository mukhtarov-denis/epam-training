package by.epam.training.lab3.v1.entity.parameter.visual;

import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;

public class Temperature extends AbstractParameter {
    private String note;
    private int temperature;
    
    public Temperature(String name, String value) {
        super(name, value);
        temperature = Integer.parseInt(value);
    }

    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public String value() {
        return String.valueOf(temperature);
    }
}