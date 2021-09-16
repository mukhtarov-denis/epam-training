package by.epam.training.course.entity.user;

import by.epam.training.course.comparator.filter.RoleFilter;
import by.epam.training.course.comparator.filter.StudentFilter;
import by.epam.training.course.entity.DBRole;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.service.ServiceFactory;
import by.epam.training.course.service.impl.ServiceFactoryImpl;

public class StudentState implements UserState {
    
    @Override
    public DBRole getRole() {
        return DBRole.STUDENT;
    }
        
    @Override
    public void setState(UserContext context) throws ServiceException, ServiceFactoryException {
        RoleFilter filter = new StudentFilter();
        if (filter.check(context.getPerson().getUser())) {
            context.setStudent(true);
            context.setTeacher(false);
            context.setNotLogged(false);
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            Student student = serviceFactory.getStudentService().find(context.getPerson().getUser().getId());
            context.getPerson().setSurname(student.getSurname());
            context.getPerson().setName(student.getName());
            context.getPerson().setPatronymic(student.getPatronymic());
            context.getPerson().setBornDate(student.getBornDate());
        } else {
            context.setState(new TeacherState());
            context.define();
        }
    }
}