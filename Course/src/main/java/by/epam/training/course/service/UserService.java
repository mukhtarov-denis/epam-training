package by.epam.training.course.service;

import java.util.List;

import by.epam.training.course.entity.Person;
import by.epam.training.course.entity.User;
import by.epam.training.course.exception.ServiceException;

public interface UserService extends BaseService<User> {
    User findByUsername(String username) throws ServiceException;
    Person findUser(String username) throws ServiceException;
    List<User> findAll() throws ServiceException;
}