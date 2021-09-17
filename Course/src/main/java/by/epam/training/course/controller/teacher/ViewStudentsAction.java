package by.epam.training.course.controller.teacher;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.Convert;

public class ViewStudentsAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Integer idTeacher = Convert.getIntValue(req.getParameter("idTeacher"));
        if (idTeacher != null) {      
            try {
                Teacher teacher = getServiceFactory().getTeacherService().find(idTeacher);
                List<Mark> marks = getServiceFactory().getMarkService().findByTeacher(teacher);
                req.setAttribute("teacher", teacher);
                req.setAttribute("marks", marks);
            } catch (ServiceException | ServiceFactoryException e) {
                throw new ServletException(e);
            }
            Forward forward = new Forward("/student/students", false);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.teacher.id_is_null");
        }
    }
}