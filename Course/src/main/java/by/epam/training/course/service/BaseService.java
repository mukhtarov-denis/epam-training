package by.epam.training.course.service;

import by.epam.training.course.exception.ServiceException;

public interface BaseService<T> {
    T find(Integer id) throws ServiceException;
    Integer insert(T entity) throws ServiceException;
    int update(T entity)  throws ServiceException;
    int delete(T entity) throws ServiceException;
}