package by.epam.training.course.service;

import java.util.List;
import java.util.Map;

import by.epam.training.course.entity.Course;
import by.epam.training.course.exception.ServiceException;

public interface CourseService extends BaseService<Course> {
    List<Course> findAll() throws ServiceException;
    Map<Course, Boolean> findAvailable() throws ServiceException;
}