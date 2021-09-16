package by.epam.training.course.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.dao.impl.DaoFactory;
import by.epam.training.course.transaction.Transaction;

public abstract class AbstractService {
    protected static final Logger logger = LogManager.getLogger();
    private DaoFactory daoFactory;
    private Transaction transaction;
    
    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
    
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public Transaction getTransaction() {
        return transaction;
    }
    
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}