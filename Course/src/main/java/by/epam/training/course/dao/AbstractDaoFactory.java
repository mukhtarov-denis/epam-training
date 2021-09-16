package by.epam.training.course.dao;

import by.epam.training.course.exception.DaoFactoryException;

public abstract class AbstractDaoFactory extends AbstractDao {
    public abstract MarkDao getMarkDao() throws DaoFactoryException;
    public abstract CourseDao getCourseDao() throws DaoFactoryException;
    public abstract StudentDao getStudentDao() throws DaoFactoryException;
    public abstract TeacherDao getTeacherDao() throws DaoFactoryException;
    public abstract UserDao getUserDao() throws DaoFactoryException;
    public abstract RoleDao getRoleDao() throws DaoFactoryException;
}