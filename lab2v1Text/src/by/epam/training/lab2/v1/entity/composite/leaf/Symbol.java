package by.epam.training.lab2.v1.entity.composite.leaf;

import by.epam.training.lab2.v1.entity.composite.AbstractComponent;
import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;
import by.epam.training.lab2.v1.entity.type.Type;

public class Symbol extends AbstractComponent {
    private char value;
    
    public Symbol(Type type) {
        super(type);
    }
    
    public Symbol(Type type, char value) {
        super(type);
        this.value = value;
    }
    
    public char getSymbol() {
        return value;
    }

    @Override
    public void build(StringBuilder text) {
        value = text.charAt(0);
    }

    @Override
    public StringBuilder read(Visitor visitor) {
        return visitor.read(this);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}