package by.epam.training.course.controller.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.user.UserContext;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;

/*
 * Получить все курсы студента
 * */
public class ViewCoursesAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        UserContext userContext = (UserContext) req.getSession().getAttribute("session_user_context");
        try {
            Student student = getServiceFactory().getStudentService().find(userContext.getPerson().getUser().getId());
            req.setAttribute("student", student);
        } catch (ServiceException | ServiceFactoryException e) {
            throw new ServletException(e);
        }
        Forward forward = new Forward("/student/student_courses", false);
        return forward;
    }
}