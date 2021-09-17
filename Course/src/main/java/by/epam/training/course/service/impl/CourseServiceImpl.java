package by.epam.training.course.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.dao.MarkDao;
import by.epam.training.course.dao.StudentDao;
import by.epam.training.course.dao.TeacherDao;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.filter.EntityFilter;
import by.epam.training.course.entity.filter.SignUpCourse;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.CourseService;

public class CourseServiceImpl extends AbstractService implements CourseService {
    private CourseDao courseDao;
    private TeacherDao teacherDao;
    private MarkDao markDao;
    private StudentDao studentDao;
    
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }
    
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public Course find(Integer id) throws ServiceException {
        try {
            getTransaction().start();
            Course course = courseDao.read(id);
            setTeacher(course);
            setStudents(course);
            getTransaction().commit();
            return course;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findById, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }

    @Override
    public List<Course> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<Course> courses = courseDao.readAll();
            for (Course course : courses) {
                setTeacher(course);
            }
            getTransaction().commit();
            return courses;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findAll, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    @Override
    public Map<Course, Boolean> findAvailable() throws ServiceException {
        try {
            getTransaction().start();
            Map<Course, Boolean> courses = new HashMap<>();
            EntityFilter<Course> courseFilter = new SignUpCourse();
            for (Course course : courseDao.readAll()) {
                setTeacher(course);
                courses.put(course, courseFilter.check(course));
            }
            getTransaction().commit();
            return courses;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findAvailable, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    public Integer insert(Course entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int update(Course entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int delete(Course entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
    
    private void setTeacher(Course course) throws DaoException {
        if (course != null) {
            course.setTeacher(teacherDao.read(course.getTeacher().getId()));
        }
    }
    
    private void setStudents(Course course) throws DaoException {
        List<Mark> marks = markDao.readByCourse(course);
        for (Mark mark : marks) {
            Student student = studentDao.read(mark.getStudent().getId());
            course.getStudents().add(student);
        }
    }
}