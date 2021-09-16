package by.epam.training.course.exception;

public class TransactionException extends Exception {
    private static final long serialVersionUID = 1L;

    public TransactionException(String message, Throwable e) {
        super(message, e);
    }
}