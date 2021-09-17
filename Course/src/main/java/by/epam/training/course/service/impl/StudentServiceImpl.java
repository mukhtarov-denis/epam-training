package by.epam.training.course.service.impl;

import java.util.List;

import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.dao.MarkDao;
import by.epam.training.course.dao.StudentDao;
import by.epam.training.course.dao.TeacherDao;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.DaoException;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.TransactionException;
import by.epam.training.course.service.AbstractService;
import by.epam.training.course.service.StudentService;

public class StudentServiceImpl extends AbstractService implements StudentService {
    private StudentDao studentDao;
    private MarkDao markDao;
    private CourseDao courseDao;
    private TeacherDao teacherDao;
    
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }
    
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    public Student find(Integer id) throws ServiceException {
        try {
            getTransaction().start();
            Student student = studentDao.read(id);
            if (student != null) {
                setCourses(student);
            }
            getTransaction().commit();
            return student;
        } catch (DaoException | TransactionException e) {
            try {
                getTransaction().rollback();
            } catch (TransactionException transactionE) {}
            String message = "Error findById, " + e.getMessage();
            logger.error(message);
            throw new ServiceException(message, e);
        }
    }
    
    public Integer insert(Student entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int update(Student entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public int delete(Student entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
    
    private void setCourses(Student student) throws DaoException {
        List<Mark> marks = markDao.readByStudent(student);
        for (Mark mark : marks) {
            Course course = courseDao.read(mark.getCourse().getId());
            course.setTeacher(teacherDao.read(course.getTeacher().getId()));
            mark.setCourse(course);
        }
        student.setMarks(marks);
    }
}