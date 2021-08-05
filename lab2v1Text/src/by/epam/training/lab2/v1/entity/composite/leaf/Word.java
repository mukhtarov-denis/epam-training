package by.epam.training.lab2.v1.entity.composite.leaf;

import by.epam.training.lab2.v1.entity.composite.AbstractComponent;
import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;
import by.epam.training.lab2.v1.entity.type.WordType;

public class Word extends AbstractComponent {
    private String value;
    
    public Word() {
        super(new WordType());
    }

    public String getWord() {
        return value;
    }
    
    @Override
    public void build(StringBuilder text) {
        value = text.toString();
    }

    @Override
    public StringBuilder read(Visitor visitor) {
        return visitor.read(this);
    }
}