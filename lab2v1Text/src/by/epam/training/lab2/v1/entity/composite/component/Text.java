package by.epam.training.lab2.v1.entity.composite.component;

import java.util.regex.Pattern;

import by.epam.training.lab2.v1.entity.composite.AbstractComposite;
import by.epam.training.lab2.v1.entity.composite.Component;
import by.epam.training.lab2.v1.entity.composite.leaf.Symbol;
import by.epam.training.lab2.v1.entity.type.CarriageReturn;
import by.epam.training.lab2.v1.entity.type.TextType;

public class Text extends AbstractComposite {
    private final String PARAGRAPH_SPLITTER ="\\n*\\s*\\n+";
    
    public Text() {
        super(new TextType());
    }
    
    private void deleteBOM(StringBuilder text) {
        if ('\uFEFF' == text.charAt(0)) {
            text.delete(0, 1);
        }
    }
    
    @Override
    public void build(StringBuilder text) {
        deleteBOM(text);
        deleteSpaces(text);
        Pattern pattern = Pattern.compile(PARAGRAPH_SPLITTER);
        String[] paragraphs = pattern.split(text);
        for (String paragraph : paragraphs) {
            Component component = new Paragraph();
            component.build(new StringBuilder(paragraph));
            addComponent(component);
            Component carriageReturn = new Symbol(new CarriageReturn());
            carriageReturn.build(new StringBuilder("\n"));
            addComponent(carriageReturn);
        }  
    }
}