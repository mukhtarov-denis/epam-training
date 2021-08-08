package by.epam.training.lab3.v1.factory;

import by.epam.training.lab3.v1.Runner;

public class RunnerFactory {
    private static Runner runner;
    
    private RunnerFactory() {

    }
    
    public static Runner getInstance() {
        if (runner == null) {
            runner = new Runner();
        }
        return runner;
    }
}