package by.epam.training.course.service.impl;

import java.util.List;

import by.epam.training.course.dao.MarkDao;
import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.dao.StudentDao;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.MarkService;

public class MarkServiceImpl extends AbstractService implements MarkService {
    private MarkDao markDao;
    private StudentDao studentDao;
    private CourseDao courseDao;
    
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }
    
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    public Mark find(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mark find(Integer idCourse, Integer idStudent) throws ServiceException {
        try {
            getTransaction().start();
            Mark mark = markDao.read(idCourse, idStudent);
            setStudent(mark);
            getTransaction().commit();
            return mark;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error find(Integer idCourse, Integer idStudent), " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    public Integer insert(Mark entity) throws ServiceException {
        try {
            getTransaction().start();
            Integer id = markDao.insert(entity);
            getTransaction().commit();
            return id;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error insert(Mark entity), " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }

    public int update(Mark entity) throws ServiceException {
        try {
            getTransaction().start();
            Integer id = markDao.update(entity);
            getTransaction().commit();
            return id;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error update(Mark entity), " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }

    public int delete(Mark entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<Mark> findByCourse(Course course) throws ServiceException {
        try {
            getTransaction().start();
            List<Mark> marks = markDao.readByCourse(course);
            for (Mark mark : marks) {
                mark.setStudent(studentDao.read(mark.getStudent().getId()));
            }
            getTransaction().commit();
            return marks;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findByCourse, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    @Override
    public List<Mark> findByStudent(Student student) throws ServiceException {
        try {
            getTransaction().start();
            List< Mark> marks = markDao.readByStudent(student);
            getTransaction().commit();
            return marks;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findByStudent, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    @Override
    public List<Mark> findByTeacher(Teacher teacher) throws ServiceException {
        try {
            getTransaction().start();
            Course course = courseDao.readByTeacher(teacher);
            List<Mark> marks = markDao.readByCourse(course);
            for (Mark mark : marks) {
                mark.setStudent(studentDao.read(mark.getStudent().getId()));
            }
            getTransaction().commit();
            return marks;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findByCourse, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    private void setStudent(Mark mark) throws DaoException {
        mark.setStudent(studentDao.read(mark.getStudent().getId()));
    }
}