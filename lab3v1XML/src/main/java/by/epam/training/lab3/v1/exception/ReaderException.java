package by.epam.training.lab3.v1.exception;

public class ReaderException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReaderException(String message, Throwable e) {
        super(message, e);
    }
}