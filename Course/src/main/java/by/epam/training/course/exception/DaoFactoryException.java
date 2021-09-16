package by.epam.training.course.exception;

public class DaoFactoryException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public DaoFactoryException(String message, Throwable e) {
        super(message, e);
    }

}