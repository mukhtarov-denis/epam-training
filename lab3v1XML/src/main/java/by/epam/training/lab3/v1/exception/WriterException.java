package by.epam.training.lab3.v1.exception;

public class WriterException extends Exception {
    private static final long serialVersionUID = 1L;

    public WriterException(String message, Throwable e) {
        super(message, e);
    }
}