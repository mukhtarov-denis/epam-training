package by.epam.training.course.controller.mark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.filter.CourseComplete;
import by.epam.training.course.entity.filter.EntityFilter;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.service.ServiceFactory;
import by.epam.training.course.util.Convert;

/*
 * Action для просмотра/выставления оценок студентом/преподавателем
 *  
 */
public class MarkAction extends Action {

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Integer idCourse = Convert.getIntValue(request.getParameter("idCourse"));
        Integer idStudent = Convert.getIntValue(request.getParameter("idStudent"));
        if (idCourse != null && idStudent != null) {
            Mark mark = null;
            Course course = null;
            try {
                ServiceFactory factory = getServiceFactory();
                mark = factory.getMarkService().find(idCourse, idStudent);
                course = factory.getCourseService().find(idCourse);
                if (mark.getValue() != null) {
                    request.setAttribute("readonly", "readonly");
                }
                EntityFilter<Course> filter = new CourseComplete();
                if (!filter.check(course)) {
                    request.setAttribute("errorMessage", "course.messages.notFinish");
                }
            } catch (ServiceException | ServiceFactoryException e) {
                String catchMessage = String.format("Error get mark/course for idCourse=%d, idStudent=%d", idCourse, idStudent);
                logger.error(catchMessage);
                throw new ServletException(catchMessage, e);
            }
            request.setAttribute("mark", mark);
            request.setAttribute("course", course);
            Forward forward = new Forward("/mark/mark", false);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.incorrect_values");
        }
    }
}