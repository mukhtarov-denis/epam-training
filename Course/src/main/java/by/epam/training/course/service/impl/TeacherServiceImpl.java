package by.epam.training.course.service.impl;

import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.dao.TeacherDao;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.TeacherService;

public class TeacherServiceImpl extends AbstractService implements TeacherService {
    private TeacherDao teacherDao;
    private CourseDao courseDao;
    
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    public Teacher find(Integer id) throws ServiceException {
        try {
            getTransaction().start();
            Teacher teacher = teacherDao.read(id);
            if (teacher != null) {
                teacher.setCourse(courseDao.read(id));
            }
            getTransaction().commit();
            return teacher;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findById, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }

    public Integer insert(Teacher entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int update(Teacher entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int delete(Teacher entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}