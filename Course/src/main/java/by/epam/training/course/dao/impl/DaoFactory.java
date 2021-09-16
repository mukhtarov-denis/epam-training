package by.epam.training.course.dao.impl;

import by.epam.training.course.dao.AbstractDaoFactory;
import by.epam.training.course.dao.MarkDao;
import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.dao.RoleDao;
import by.epam.training.course.dao.StudentDao;
import by.epam.training.course.dao.TeacherDao;
import by.epam.training.course.dao.UserDao;
import by.epam.training.course.exception.DaoFactoryException;

public class DaoFactory extends AbstractDaoFactory {

    @Override
    public MarkDao getMarkDao() throws DaoFactoryException {
        MarkDaoImpl dao = new MarkDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public CourseDao getCourseDao() throws DaoFactoryException {
        CourseDaoImpl dao = new CourseDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public StudentDao getStudentDao() throws DaoFactoryException {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public TeacherDao getTeacherDao() throws DaoFactoryException {
        TeacherDaoImpl dao = new TeacherDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public UserDao getUserDao() throws DaoFactoryException {
        UserDaoImpl dao = new UserDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public RoleDao getRoleDao() throws DaoFactoryException {
        RoleDaoImpl dao = new RoleDaoImpl();
        dao.setConnection(getConnection());
        return dao;
    }
}