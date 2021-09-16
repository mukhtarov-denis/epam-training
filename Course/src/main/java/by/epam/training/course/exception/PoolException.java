package by.epam.training.course.exception;

public class PoolException extends Exception {
    private static final long serialVersionUID = 1L;

    public PoolException(String message, Throwable e) {
        super(message, e);
    }
}