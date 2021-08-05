package by.epam.training.lab2.v1.entity.composite.component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.training.lab2.v1.entity.composite.AbstractComposite;
import by.epam.training.lab2.v1.entity.composite.Component;
import by.epam.training.lab2.v1.entity.composite.leaf.Word;
import by.epam.training.lab2.v1.entity.type.SentenceType;

public class Sentence extends AbstractComposite {
    private final String REGEXP_EMAIL = "[\\w\\.-]+@[a-z]+\\.[a-z]{2,}";
    private final String REGEXP_PHONE = "\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}";
    private final String REGEXP_WORD = "[а-яА-яa-zA-Z\\d]{1}[а-яА-яa-zA-Z\\d-]*";
    
    public Sentence() {
        super(new SentenceType());
    }

    @Override
    public void build(StringBuilder text) {
        Pattern pattern = Pattern.compile("(" + REGEXP_EMAIL + ")"
                                  + "|" + "(" + REGEXP_PHONE + ")"
                                  + "|" + "(" + REGEXP_WORD + ")");
        Matcher matcher = pattern.matcher(text);
        int position = 0;
        while (matcher.find()) {
            String delimeters = text.substring(position, matcher.start());
            addComponents(getDelimeters(delimeters));
            Component word = new Word();
            word.build(new StringBuilder(matcher.group()));
            addComponent(word);
            position = matcher.end();
        }
        String endSentence = text.substring(position, text.length());
        addComponents(getDelimeters(endSentence));
    }
}