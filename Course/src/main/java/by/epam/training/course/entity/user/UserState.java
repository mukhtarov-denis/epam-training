package by.epam.training.course.entity.user;

import by.epam.training.course.entity.DBRole;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;

public interface UserState {
    DBRole getRole();
    void setState(UserContext context) throws ServiceException, ServiceFactoryException;
}