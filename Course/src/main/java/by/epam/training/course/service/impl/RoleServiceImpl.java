package by.epam.training.course.service.impl;

import java.util.List;

import by.epam.training.course.dao.RoleDao;
import by.epam.training.course.entity.Role;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.RoleService;

public class RoleServiceImpl extends AbstractService implements RoleService {
    private RoleDao roleDao;
    
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    public Role find(Integer id) throws ServiceException {
        try {
            getTransaction().start();
            Role role = roleDao.read(id);
            getTransaction().commit();
            return role;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find role by id, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }

    @Override
    public List<Role> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<Role> roles = roleDao.readAll();
            getTransaction().commit();
            return roles;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find add roles, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    public Integer insert(Role entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int update(Role entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int delete(Role entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}