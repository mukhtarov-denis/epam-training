package by.epam.training.course.controller.course;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Course;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;

/*
 * Список всех курсов
 * */
public class CourseAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Map<Course, Boolean> courses = null;
        try {
            courses = getServiceFactory().getCourseService().findAvailable();
            req.setAttribute("courses", courses);
        } catch (ServiceException | ServiceFactoryException e) {
            String catchMessage = String.format("Error get all available courses");
            logger.error(catchMessage);
            throw new ServletException(catchMessage, e);
        }
        Forward forward = new Forward("/course/course", false);
        return forward;
    }
}