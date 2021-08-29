package by.epam.training.lab3.v1.exception;

public class ApplicationException extends Exception {
    private static final long serialVersionUID = 1L;

    public ApplicationException(String message, Throwable e) {
        super(message, e);
    }
}