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
import by.epam.training.lab2.v1.exception.WriterException;
import by.epam.training.lab2.v1.filter.impl.SentenceTypeFilter;
import by.epam.training.lab2.v1.filter.impl.WordTypeFilter;
import by.epam.training.lab2.v1.reader.TextReader;
import by.epam.training.lab2.v1.reader.impl.FileTextReader;
import by.epam.training.lab2.v1.writer.TextWriter;
import by.epam.training.lab2.v1.writer.impl.FileTextWriter;

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
        StringBuilder logProcess = new StringBuilder();
        File inputFile = new File("capital.txt");
        TextReader textReader = new FileTextReader(inputFile);
        logProcess.append("Начато чтение файла").append("\n");
        long start = getTimeInMillis();
        StringBuilder sb;
        try {
            sb = textReader.read();
        } catch (FileReaderException e) {
            throw new ApplicationException("Ошибка приложения при обработке данных", e);
        }
        long end = getTimeInMillis();
        logProcess.append(String.format("Время чтения файла: %.3f сек.\n", getDuration(start, end)));
        logProcess.append("Началась обработка данных...\n");
        start = getTimeInMillis();
        Component text = new Text();
        text.build(sb);
        end = getTimeInMillis();
        logProcess.append(String.format("Время обработки данных: %.3f сек.\n", getDuration(start, end)));
        logProcess.append("Получение всех слов и предложений...\n");
        start = getTimeInMillis();
        List<Component> words = text.getElements(new WordTypeFilter());
        List<Component> sentences = text.getElements(new SentenceTypeFilter());
        end = getTimeInMillis();
        logProcess.append("Время получения: ").append(String.format("%.3f", getDuration(start, end))).append(" сек.\n");
        logProcess.append(String.format("Время получения: %.3f сек.\n", getDuration(start, end)));
        start = getTimeInMillis();
        Map<Component, Set<Component>> wordMap = new HashMap<>();
        for (Component word : words) {
            wordMap.put(word, new HashSet<>());
        }
        end = getTimeInMillis();
        logProcess.append(String.format("Время формирования множества уникальных слов: %.3f сек.\n", getDuration(start, end)));
        logProcess.append(String.format("В тексте: %d предложений\n", sentences.size()));
        logProcess.append(String.format("В тексте: %d слов(о,а), уникальных: %d\n\n", words.size(), wordMap.keySet().size()));
        logProcess.append("Формирование карты множества предложений для уникальных слов...\n");
        start = getTimeInMillis();
        for (Component sentence : sentences) {
            addSentence(wordMap, sentence);
        }
        end = getTimeInMillis();
        logProcess.append(String.format("Время формирования карты: %.3f сек.\n\n", getDuration(start, end)));
        logProcess.append("Вывод карты...");
        start = getTimeInMillis();
        for (Entry<Component, Set<Component>> entry : wordMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                logProcess.append(String.format("Слово \"%s\" содержится в %d предложениях:\n", entry.getKey(), entry.getValue().size()));
                for (Component sentence : entry.getValue()) {
                    int occurrences = Collections.frequency(sentence.getElements(new WordTypeFilter()), entry.getKey());
                    logProcess.append(String.format("\t%d раз(а) в \"%s\"\n", occurrences, sentence));
                }
            }
        }
        end = getTimeInMillis();
        logProcess.append(String.format("Время вывода карты: %.3f сек.\n\n", getDuration(start, end)));
        start = getTimeInMillis();
        int maxValue = 0;
        for (Entry<Component, Set<Component>> entry : wordMap.entrySet()) {
            if (entry.getValue().size() > maxValue) {
                maxValue = entry.getValue().size();
            }
        }
        end = getTimeInMillis();
        StringBuilder result = new StringBuilder();
        result.append(String.format("Наибольшее количество предложений текста, в которых есть одинаковые слова: %d\n", maxValue));
        result.append(String.format("Время поиска: %.3f сек.\n\n", getDuration(start, end)));
        result.append("Процесс выполнения:\n\n");
        result.append(logProcess);
        TextWriter tw = new FileTextWriter();
        try {
            tw.write(new File("output.txt"), result);
        } catch (WriterException e) {
            throw new ApplicationException("Error write data to file", e);
        }
    }
}