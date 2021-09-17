package by.epam.training.course.service.impl;

import java.util.List;
import java.util.Set;

import by.epam.training.course.dao.RoleDao;
import by.epam.training.course.dao.UserDao;
import by.epam.training.course.entity.Person;
import by.epam.training.course.entity.Role;
import by.epam.training.course.entity.User;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.UserService;

public class UserServiceImpl extends AbstractService implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;
    
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    public User find(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User findByUsername(String username) throws ServiceException {
        try {
            getTransaction().start();
            User user = userDao.readByUsername(username);
            if (user != null) {
                Set<Role> roles = roleDao.readUserRole(user.getId());
                user.setRoles(roles);
            }
            getTransaction().commit();
            return user;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find by username ..., " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    @Override
    public Person findUser(String username) throws ServiceException {
        try {
            getTransaction().start();
            Person person = null;
            User user = userDao.readByUsername(username);            
            if (user != null) {
                Set<Role> roles = roleDao.readUserRole(user.getId());
                user.setRoles(roles);
            }
            getTransaction().commit();
            return person;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find Person by username ..., " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }    

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<User> users = userDao.readAll();
            for (User user : users) {
                Set<Role> roles = roleDao.readUserRole(user.getId());
                user.setRoles(roles);
            }
            getTransaction().commit();
            return users;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find all users ..., " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    public Integer insert(User entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int update(User entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int delete(User entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}