package by.epam.training.lab2.v1;

import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import by.epam.training.lab2.v1.entity.composite.Component;
import by.epam.training.lab2.v1.entity.composite.component.Text;
import by.epam.training.lab2.v1.exception.ApplicationException;
import by.epam.training.lab2.v1.exception.FileReaderException;
import by.epam.training.lab2.v1.filter.impl.SentenceTypeFilter;
import by.epam.training.lab2.v1.filter.impl.WordTypeFilter;
import by.epam.training.lab2.v1.reader.TextReader;
import by.epam.training.lab2.v1.reader.impl.FileTextReader;

public class Runner {
    
    private long getTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }
    
    private double getDuration(long startMillis, long endMillis) {
        return (double) TimeUnit.MILLISECONDS.toMillis(endMillis - startMillis) / 1000; 
    }
    
    private void addSentence(Map<Component, Set<Component>> wordMap, Component sentence) {
        for (int i = 0; i < sentence.size(); i++) {
            if (wordMap.containsKey(sentence.getChild(i))) {
                wordMap.get(sentence.getChild(i)).add(sentence);
            }
        }
    }
    
    public void run() throws ApplicationException {
        File inputFile = new File("inputText.txt");
        TextReader textReader = new FileTextReader(inputFile);
        System.out.println("Начато чтение файла");
        long start = getTimeInMillis();
        StringBuilder sb;
        try {
            sb = textReader.read();
        } catch (FileReaderException e) {
            throw new ApplicationException("Ошибка приложения при обработке данных", e);
        }
        long end = getTimeInMillis();
        System.out.printf("Время чтения файла: %.3f сек.\n", getDuration(start, end));
        System.out.println("Началась обработка данных...");
        start = getTimeInMillis();
        Component text = new Text();
        text.build(sb);
        end = getTimeInMillis();
        System.out.printf("Время обработки данных: %.3f сек.\n", getDuration(start, end));
        System.out.println("Получение всех слов и предложений...");
        start = getTimeInMillis();
        List<Component> words = text.getElements(new WordTypeFilter());
        List<Component> sentences = text.getElements(new SentenceTypeFilter());
        end = getTimeInMillis();
        System.out.printf("Время получения: %.3f сек.\n", getDuration(start, end));
        
        System.out.println("Формирование множества уникальных слов...");
        start = getTimeInMillis();
        Map<Component, Set<Component>> wordMap = new HashMap<>();
        for (Component word : words) {
            wordMap.put(word, new HashSet<>());
        }
        end = getTimeInMillis();
        System.out.printf("Время формирования множества уникальных слов: %.3f сек.\n", getDuration(start, end));        
        System.out.printf("В тексте: %d предложений\n", sentences.size());
        System.out.printf("В тексте: %d слов(о,а), уникальных: %d\n", words.size(), wordMap.keySet().size());
        System.out.println("*************************************************");
        
        System.out.println("Формирование карты множества предложений для уникальных слов...");
        start = getTimeInMillis();
        for (Component sentence : sentences) {
            addSentence(wordMap, sentence);
        }
        end = getTimeInMillis();
        System.out.printf("Время формирования карты: %.3f сек.\n", getDuration(start, end));
        System.out.println("*************************************************");
        
        System.out.println("Вывод карты...");
        start = getTimeInMillis();
        for (Entry<Component, Set<Component>> entry : wordMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.printf("Слово \"%s\" содержится в %d предложениях:\n", entry.getKey(), entry.getValue().size());
                for (Component sentence : entry.getValue()) {
                    int occurrences = Collections.frequency(sentence.getElements(new WordTypeFilter()), entry.getKey());
                    System.out.printf("\t%d раз(а) в \"%s\"\n", occurrences, sentence);
                }
            }
        }
        end = getTimeInMillis();
        System.out.printf("Время вывода карты: %.3f сек.\n", getDuration(start, end));
        System.out.println("*************************************************");

        System.out.println("Поиск количества предложений...");
        start = getTimeInMillis();
        int maxValue = 0;
        for (Entry<Component, Set<Component>> entry : wordMap.entrySet()) {
            if (entry.getValue().size() > maxValue) {
                maxValue = entry.getValue().size();
            }
        }
        end = getTimeInMillis();
        System.out.printf("Наибольшее количество предложений текста, в которых есть одинаковые слова: %d\n", maxValue);
        System.out.printf("Время поиска: %.3f сек.\n", getDuration(start, end));
        System.out.println("*************************************************");
    }
}