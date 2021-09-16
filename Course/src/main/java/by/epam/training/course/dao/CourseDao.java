package by.epam.training.course.dao;

import java.util.List;

import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.DaoException;

public interface CourseDao extends Dao<Course> {
    Course readByTeacher(Teacher teacher) throws DaoException;
    List<Course> readAll() throws DaoException;
}