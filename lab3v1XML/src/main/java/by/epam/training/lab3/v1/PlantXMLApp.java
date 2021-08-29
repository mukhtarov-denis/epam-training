package by.epam.training.lab3.v1;

import by.epam.training.lab3.v1.exception.ApplicationException;
import by.epam.training.lab3.v1.factory.RunnerFactory;

public class PlantXMLApp {
    public static void main(String[] args) {
        Runner runner = RunnerFactory.getInstance();
        try {
            runner.run();
        } catch (ApplicationException e) {
            System.out.println("Application error...");
            System.out.printf("Message: %s\nCause:\n%s\n",e.getMessage(), e.getCause().getMessage());
        }
        System.out.println("Done.");
    }
}