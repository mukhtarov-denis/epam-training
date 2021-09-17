package by.epam.training.course.controller.course;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.Convert;

/*
 * Список студентов курса по idCourse
 * */
public class CourseInfoAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {        
        Integer idCourse = Convert.getIntValue(req.getParameter("idCourse"));
        if (idCourse != null) {
            Course course = new Course();
            course.setId(idCourse);
            List<Mark> marks = null;
            if (course.getId() != null) {
                try {
                    marks = getServiceFactory().getMarkService().findByCourse(course);
                    course = getServiceFactory().getCourseService().find(course.getId());
                } catch (ServiceException | ServiceFactoryException e) {
                    String catchMessage = String.format("Error get marks(students)/course for idCourse=%d ", idCourse);
                    logger.error(catchMessage);
                    throw new ServletException(catchMessage, e);
                }
                req.setAttribute("course", course);
                req.setAttribute("marks", marks);
            }
            Forward forward = new Forward("/course/course_info", false);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.incorrect_values");
        }
    }
}