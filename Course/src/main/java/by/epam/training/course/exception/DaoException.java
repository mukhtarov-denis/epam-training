package by.epam.training.course.exception;

public class DaoException extends Exception {
    private static final long serialVersionUID = 1L;

    public DaoException(String message, Throwable e) {
        super(message, e);
    }
}