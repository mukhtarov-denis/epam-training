package by.epam.training.lab3.v1.reader;

import java.util.List;

import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.exception.ReaderException;

public interface Reader {
    List<Plant> read() throws ReaderException;
}