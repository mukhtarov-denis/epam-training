package by.epam.training.course.service;

import java.util.List;

import by.epam.training.course.entity.Role;
import by.epam.training.course.exception.ServiceException;

public interface RoleService extends BaseService<Role> {
    List<Role> findAll() throws ServiceException;
}