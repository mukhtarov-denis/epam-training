package by.epam.training.lab2.v1.entity.composite.visitor;

import by.epam.training.lab2.v1.entity.composite.component.Paragraph;
import by.epam.training.lab2.v1.entity.composite.component.Sentence;
import by.epam.training.lab2.v1.entity.composite.component.Text;
import by.epam.training.lab2.v1.entity.composite.leaf.Symbol;
import by.epam.training.lab2.v1.entity.composite.leaf.Word;

public interface Visitor {
    StringBuilder read(Text component);
    StringBuilder read(Paragraph component);
    StringBuilder read(Sentence component);
    StringBuilder read(Word component);
    StringBuilder read(Symbol component);
}