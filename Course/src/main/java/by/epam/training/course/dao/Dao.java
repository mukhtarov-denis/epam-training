package by.epam.training.course.dao;

import by.epam.training.course.exception.DaoException;

public interface Dao<T> {
    T read(Integer id) throws DaoException;
    Integer insert(T entity) throws DaoException;
    int update(T entity) throws DaoException;
    int delete(T entity) throws DaoException;
}