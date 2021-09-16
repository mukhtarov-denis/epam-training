package by.epam.training.course.dao;

import java.util.List;

import by.epam.training.course.entity.User;
import by.epam.training.course.exception.DaoException;

public interface UserDao extends Dao<User> {
    User readByUsername(String username) throws DaoException;
    List<User> readAll() throws DaoException;
}