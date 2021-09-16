package by.epam.training.course.transaction;

import by.epam.training.course.exception.TransactionException;

public interface Transaction {
    void start() throws TransactionException;
    void rollback() throws TransactionException;
    void commit() throws TransactionException;
}