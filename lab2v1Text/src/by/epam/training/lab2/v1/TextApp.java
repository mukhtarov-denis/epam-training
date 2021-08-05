package by.epam.training.lab2.v1;

import by.epam.training.lab2.v1.exception.ApplicationException;
import by.epam.training.lab2.v1.factory.RunnerFactory;

/*
 * Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 * */
public class TextApp {
    
    public static void main(String[] args) {
        try {
            RunnerFactory.getInstance().run();
        } catch (ApplicationException e) {
            System.out.printf("Message: %s\nCause: %s\n",e.getMessage(), e.getCause().getMessage());
        }
        System.out.println("Done");
    }
}