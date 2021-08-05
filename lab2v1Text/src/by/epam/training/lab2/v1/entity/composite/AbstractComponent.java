package by.epam.training.lab2.v1.entity.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.training.lab2.v1.entity.composite.leaf.Symbol;
import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;
import by.epam.training.lab2.v1.entity.composite.visitor.impl.VisitorImpl;
import by.epam.training.lab2.v1.entity.type.PunctuationSymbol;
import by.epam.training.lab2.v1.entity.type.SpaceSymbol;
import by.epam.training.lab2.v1.entity.type.Type;
import by.epam.training.lab2.v1.filter.Filter;

public abstract class AbstractComponent implements Component {
    private Type type;
    
    public AbstractComponent(Type type) {
        this.type = type;
    }
        
    protected void deleteSpaces(StringBuilder text) {
        Pattern spacePattern = Pattern.compile("[\\t ]{2,}");
        Matcher spaceMatcher = spacePattern.matcher(text);
        text.replace(0, text.length(), spaceMatcher.replaceAll(" "));
    }
    
    protected List<Component> getDelimeters(String delimeters) {
        List<Component> delimetersList = new ArrayList<>();
        for (int i = 0; i < delimeters.length(); i++) {
            char symbol = delimeters.charAt(i);
            Component component;
            if (Character.isSpaceChar(symbol)) {
                component = new Symbol(new SpaceSymbol());
            } else {
                component = new Symbol(new PunctuationSymbol());
            }
            component.build(new StringBuilder().append(symbol));
            delimetersList.add(component);
        }
        return delimetersList;
    }
    
    @Override
    public Type type() {
        return type;
    }
    
    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException("Because it is a leaf component");
    }
    
    @Override
    public void addComponents(List<Component> components) {
        throw new UnsupportedOperationException("Because it is a leaf component");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Because it is a leaf component");
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    public List<Component> getElements(Filter filter) {
        List<Component> list = new ArrayList<>();
        if (filter.check(this)) {
            list.add(this);
        }
        return list;
    }
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        AbstractComponent otherComponent = (AbstractComponent) object;
        return this.toString().equals(otherComponent.toString());
    }

    @Override
    public String toString() {
        Visitor visitor = new VisitorImpl();
        return this.read(visitor).toString();
    }
}