package by.epam.training.lab2.v1.entity.composite;

import java.util.List;

import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;
import by.epam.training.lab2.v1.entity.type.Type;
import by.epam.training.lab2.v1.filter.Filter;

public interface Component {
    Type type();
    void addComponent(Component component);
    void addComponents(List<Component> components);
    Component getChild(int index);
    void build(StringBuilder text);
    int size();
    StringBuilder read(Visitor visitor);
    List<Component> getElements(Filter filter);
}