package by.epam.training.lab3.v1.entity.parameter;

public abstract class AbstractParameter implements Parameter {
    private String name;
    protected String note;
    protected String value;
        
    public AbstractParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    @Override
    public String name() {
        return name;
    }
    
    @Override
    public String note() {
        return "";
    }
}