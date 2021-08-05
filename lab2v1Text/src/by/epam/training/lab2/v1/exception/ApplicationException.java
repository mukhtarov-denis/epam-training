package by.epam.training.lab2.v1.exception;

public class ApplicationException extends Exception {
    private static final long serialVersionUID = -5362403214538548105L;

    public ApplicationException(String message, Throwable e) {
        super(message, e);
    }
}