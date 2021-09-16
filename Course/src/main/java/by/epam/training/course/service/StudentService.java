package by.epam.training.course.service;

import java.util.List;

import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.ServiceException;

public interface StudentService extends BaseService<Student> {
    List<Student> findByTeacher(Teacher teacher) throws ServiceException;
}