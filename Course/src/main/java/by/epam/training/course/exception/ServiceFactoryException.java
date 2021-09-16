package by.epam.training.course.exception;

public class ServiceFactoryException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public ServiceFactoryException(String message, Throwable e) {
        super(message, e);
    }
}