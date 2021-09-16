package by.epam.training.course.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import by.epam.training.course.exception.TransactionException;

public class TransactionImpl implements Transaction {
    private Connection connection;
    
    public Connection getConnection() {
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void start() throws TransactionException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new TransactionException("Transaction start exception", e);
        }
    }

    public void commit() throws TransactionException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            throw new TransactionException("Transaction commit exception", e);
        }
    }

    public void rollback() throws TransactionException {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            throw new TransactionException("Transaction rollback exception", e);
        }
    }
}