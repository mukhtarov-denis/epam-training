package by.epam.training.lab2.v1.exception;

public class WriterException extends Exception {
    private static final long serialVersionUID = 3018449282067739799L;

    public WriterException(String message, Throwable e) {
        super(message, e);
    }
}
