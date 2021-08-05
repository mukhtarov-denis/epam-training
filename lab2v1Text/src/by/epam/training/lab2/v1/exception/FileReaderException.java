package by.epam.training.lab2.v1.exception;

public class FileReaderException extends Exception {
    private static final long serialVersionUID = -6851617387051948076L;

    public FileReaderException(String message, Throwable e) {
        super(message, e);
    }
}