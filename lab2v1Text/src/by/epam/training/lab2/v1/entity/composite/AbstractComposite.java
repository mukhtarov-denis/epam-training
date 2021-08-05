package by.epam.training.lab2.v1.entity.composite;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;
import by.epam.training.lab2.v1.entity.type.Type;
import by.epam.training.lab2.v1.filter.Filter;

public abstract class AbstractComposite extends AbstractComponent {
    private List<Component> componentList = new ArrayList<>(); 
    
    public AbstractComposite(Type type) {
        super(type);
    }
    
    @Override
    public void addComponent(Component component) {
        componentList.add(component);   
    }
    
    @Override
    public void addComponents(List<Component> components) {
        for (Component component : components) {
            componentList.add(component);
        }
    }
    
    @Override
    public Component getChild(int index) {
        return componentList.get(index);
    }
    
    @Override
    public int size() {
        return componentList.size();
    }
    
    @Override
    public StringBuilder read(Visitor visitor) {
        StringBuilder text = new StringBuilder();
        for (Component component : componentList) {
            text.append(component.read(visitor));
        }
        return text;
    }
    
    @Override
    public List<Component> getElements(Filter filter) {
        List<Component> list = new ArrayList<>();
        for (Component component : componentList) {
            if (filter.check(component)) {
                list.add(component);
            } else {
                list.addAll(component.getElements(filter));
            }
        }
        return list;
    }
}