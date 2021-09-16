package by.epam.training.course.service;

import java.util.List;

import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.ServiceException;

public interface MarkService extends BaseService<Mark> {
    Mark find(Integer idCourse, Integer idStudent) throws ServiceException;
    List<Mark> findByCourse(Course course) throws ServiceException;
    List<Mark> findByStudent(Student student) throws ServiceException;
    List<Mark> findByTeacher(Teacher teacher) throws ServiceException;
}