package by.epam.training.course.entity.user;

import by.epam.training.course.comparator.filter.RoleFilter;
import by.epam.training.course.comparator.filter.TeacherFilter;
import by.epam.training.course.entity.DBRole;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.service.ServiceFactory;
import by.epam.training.course.service.impl.ServiceFactoryImpl;

public class TeacherState implements UserState {
    
    @Override
    public DBRole getRole() {
        return DBRole.TEACHER;
    }

    @Override
    public void setState(UserContext context) throws ServiceException, ServiceFactoryException {
        RoleFilter filter = new TeacherFilter();
        if (filter.check(context.getPerson().getUser())) {
            context.setStudent(false);
            context.setTeacher(true);
            context.setNotLogged(false);
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            Teacher teacher = serviceFactory.getTeacherService().find(context.getPerson().getUser().getId());
            context.getPerson().setSurname(teacher.getSurname());
            context.getPerson().setName(teacher.getName());
            context.getPerson().setPatronymic(teacher.getPatronymic());
            context.getPerson().setBornDate(teacher.getBornDate());
        } else {
            context.setState(new NotLoggedState());
            context.define();
        }
    }
}