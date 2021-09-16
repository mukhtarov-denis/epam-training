package by.epam.training.course.dao;

import java.util.List;

import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.DaoException;

public interface MarkDao extends Dao<Mark> {
    List<Mark> readByCourse(Course course) throws DaoException;
    List<Mark> readByStudent(Student student) throws DaoException;
    Mark read(Integer idCourse, Integer idStudent) throws DaoException;
}