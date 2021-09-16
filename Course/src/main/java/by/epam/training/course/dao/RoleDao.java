package by.epam.training.course.dao;

import java.util.List;
import java.util.Set;

import by.epam.training.course.entity.Role;
import by.epam.training.course.exception.DaoException;

public interface RoleDao extends Dao<Role> {
    Set<Role> readUserRole(Integer idUser) throws DaoException;
    List<Role> readAll() throws DaoException;
}