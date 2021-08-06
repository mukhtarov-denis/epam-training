package by.epam.training.lab3.v1.entity.parameter;

public abstract class AbstractParameter implements Parameter {
    private String name;
    private String value;
    
    @Override
    public String name() {
        return name;
    }

    @Override
    public String value() {
        return value;
    }
}