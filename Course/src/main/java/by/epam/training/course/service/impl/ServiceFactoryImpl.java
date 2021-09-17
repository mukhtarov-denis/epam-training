package by.epam.training.course.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.connection.ConnectionPool;
import by.epam.training.course.dao.impl.DaoFactory;
import by.epam.training.course.exception.DaoFactoryException;
import by.epam.training.course.exception.PoolException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.service.MarkService;
import by.epam.training.course.service.CourseService;
import by.epam.training.course.service.RoleService;
import by.epam.training.course.service.ServiceFactory;
import by.epam.training.course.service.StudentService;
import by.epam.training.course.service.TeacherService;
import by.epam.training.course.service.UserService;
import by.epam.training.course.transaction.Transaction;
import by.epam.training.course.transaction.TransactionImpl;

public class ServiceFactoryImpl implements ServiceFactory {
    private static final Logger logger = LogManager.getLogger();
    
    public MarkService getMarkService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            MarkServiceImpl service = new MarkServiceImpl();
            service.setTransaction(transaction);
            service.setMarkDao(daoFactory.getMarkDao());
            service.setStudentDao(daoFactory.getStudentDao());
            service.setMarkDao(daoFactory.getMarkDao());
            service.setStudentDao(daoFactory.getStudentDao());
            service.setCourseDao(daoFactory.getCourseDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getMarkService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }

    public CourseService getCourseService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            CourseServiceImpl service = new CourseServiceImpl();
            service.setTransaction(transaction);
            service.setCourseDao(daoFactory.getCourseDao());
            service.setMarkDao(daoFactory.getMarkDao());
            service.setStudentDao(daoFactory.getStudentDao());
            service.setTeacherDao(daoFactory.getTeacherDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getCourseService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }

    public StudentService getStudentService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            StudentServiceImpl service = new StudentServiceImpl();
            service.setTransaction(transaction);
            service.setStudentDao(daoFactory.getStudentDao());
            service.setMarkDao(daoFactory.getMarkDao());
            service.setCourseDao(daoFactory.getCourseDao());
            service.setTeacherDao(daoFactory.getTeacherDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getStudentService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }

    public TeacherService getTeacherService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            TeacherServiceImpl service = new TeacherServiceImpl();
            service.setTransaction(transaction);
            service.setTeacherDao(daoFactory.getTeacherDao());
            service.setCourseDao(daoFactory.getCourseDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getTeacherService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }

    public UserService getUserService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            UserServiceImpl service = new UserServiceImpl();
            service.setTransaction(transaction);
            service.setRoleDao(daoFactory.getRoleDao());
            service.setUserDao(daoFactory.getUserDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getUserService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }

    public RoleService getRoleService() throws ServiceFactoryException {
        try {
            Connection connection = getConnection();
            DaoFactory daoFactory = getDaoFactory(connection);
            Transaction transaction = getTransaction(connection);
            RoleServiceImpl service = new RoleServiceImpl();
            service.setTransaction(transaction);
            service.setRoleDao(daoFactory.getRoleDao());
            return service;
        } catch (DaoFactoryException e) {
            String message = "Error: getRoleService(), " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }
    
    private DaoFactory getDaoFactory(Connection connection) {
        DaoFactory daoFactory = new DaoFactory();
        daoFactory.setConnection(connection);
        return daoFactory;
    }
    
    private Transaction getTransaction(Connection connection) throws ServiceFactoryException {
        TransactionImpl transaction = new TransactionImpl();
        transaction.setConnection(connection);
        return transaction;
    }
    
    private Connection getConnection() throws ServiceFactoryException {
        try {
            return ConnectionPool.getInstance().getConnection();
        } catch (SQLException | PoolException e) {
            String message = "Error get connection from pool, " + e.getMessage();
            logger.error(message);
            throw new ServiceFactoryException(message, e);
        }
    }
}