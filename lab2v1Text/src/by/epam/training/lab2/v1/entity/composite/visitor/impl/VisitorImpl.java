package by.epam.training.lab2.v1.entity.composite.visitor.impl;

import by.epam.training.lab2.v1.entity.composite.component.Paragraph;
import by.epam.training.lab2.v1.entity.composite.component.Sentence;
import by.epam.training.lab2.v1.entity.composite.component.Text;
import by.epam.training.lab2.v1.entity.composite.leaf.Symbol;
import by.epam.training.lab2.v1.entity.composite.leaf.Word;
import by.epam.training.lab2.v1.entity.composite.visitor.Visitor;

public class VisitorImpl implements Visitor {

    @Override
    public StringBuilder read(Text component) {
        return new StringBuilder();
    }

    @Override
    public StringBuilder read(Paragraph component) {
        return new StringBuilder();
    }

    @Override
    public StringBuilder read(Sentence component) {
        return new StringBuilder();
    }

    @Override
    public StringBuilder read(Word component) {
        return new StringBuilder(component.getWord());
    }

    @Override
    public StringBuilder read(Symbol component) {
        return new StringBuilder().append(component.getSymbol());
    }
}