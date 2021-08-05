package by.epam.training.lab2.v1.writer;

import java.io.File;

import by.epam.training.lab2.v1.exception.WriterException;

public interface TextWriter {
    void write(File file, StringBuilder text) throws WriterException;
}