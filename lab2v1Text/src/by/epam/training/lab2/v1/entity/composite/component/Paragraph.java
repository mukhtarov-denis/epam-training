package by.epam.training.lab2.v1.entity.composite.component;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.training.lab2.v1.entity.composite.AbstractComposite;
import by.epam.training.lab2.v1.entity.composite.Component;
import by.epam.training.lab2.v1.entity.composite.leaf.Symbol;
import by.epam.training.lab2.v1.entity.type.ParagraphType;
import by.epam.training.lab2.v1.entity.type.SpaceSymbol;

public class Paragraph extends AbstractComposite {

    public Paragraph() {
        super(new ParagraphType());
    }

    private List<Component> getSentencePreffix(StringBuilder sentence) {
        List<Component> componentList = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[^A-Za-zА-Яа-я0-9]+");
        Matcher matcher = pattern.matcher(sentence);
        if (matcher.find()) {
            String prefix = matcher.group();
            componentList.addAll(getDelimeters(prefix));
            sentence.delete(0, prefix.length());
        }        
        return componentList;
    }
    
    private List<Component> getSentencePostfix(StringBuilder sentence) {
        List<Component> componentList = new ArrayList<>();
        if (sentence.length() > 1) {
            if (Character.isSpaceChar(sentence.charAt(sentence.length()-1))) {
                componentList.add(new Symbol(new SpaceSymbol(), ' '));
                sentence.deleteCharAt(sentence.length() - 1);
            }
        }
        return componentList;
    }
        
    @Override
    public void build(StringBuilder text) {
        BreakIterator breakIterator = BreakIterator.getSentenceInstance();
        breakIterator.setText(text.toString());
        int startIndex = breakIterator.first();
        int endIndex = breakIterator.next();
        while (BreakIterator.DONE != endIndex) {
            StringBuilder foundedSentence = new StringBuilder(text.substring(startIndex, endIndex));
            startIndex = endIndex;
            endIndex = breakIterator.next();
            List<Component> preffixComponents = getSentencePreffix(foundedSentence);
            List<Component> postfixComponents = getSentencePostfix(foundedSentence);            
            addComponents(preffixComponents);
            Sentence sentence = new Sentence();
            sentence.build(foundedSentence);
            addComponent(sentence);
            addComponents(postfixComponents);
        }
    }
}