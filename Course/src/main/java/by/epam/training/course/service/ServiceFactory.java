package by.epam.training.course.service;

import by.epam.training.course.exception.ServiceFactoryException;

public interface ServiceFactory {
    MarkService getMarkService() throws ServiceFactoryException;
    CourseService getCourseService() throws ServiceFactoryException;
    StudentService getStudentService() throws ServiceFactoryException;
    TeacherService getTeacherService() throws ServiceFactoryException;
    UserService getUserService() throws ServiceFactoryException;
    RoleService getRoleService() throws ServiceFactoryException;
}