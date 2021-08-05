package by.epam.training.lab2.v1.reader;

import by.epam.training.lab2.v1.exception.FileReaderException;

public interface TextReader {
    StringBuilder read() throws FileReaderException;
}