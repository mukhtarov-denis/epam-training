package by.epam.training.course.controller.mark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.Convert;

/*
 * Сохранение отношения "курс-студент" в базе данных
 * */
public class SaveMarkAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Mark mark = createMark(req);
        if (mark.getCourse().getId() != null && mark.getStudent().getId() != null) {
            try {
                getServiceFactory().getMarkService().insert(mark);
            } catch (ServiceException | ServiceFactoryException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error save entity \"mark\" into table \"mark\"");
                sb.append("idCourse=").append(mark.getCourse().getId());
                sb.append("idStudent=").append(mark.getStudent().getId());
                logger.error(sb.toString());
                throw new ServletException(sb.toString(), e);
            }
            Forward forward = new Forward("/app/course/signup?idCourse=" + mark.getCourse().getId(), true);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.incorrect_values");
        }
    }
    
    private Mark createMark(HttpServletRequest req) {
        String idCourse = req.getParameter("idCourse");
        String idStudent = req.getParameter("idStudent");
        Course course = new Course();
        course.setId(Convert.getIntValue(idCourse));
        Student student = new Student();
        student.setId(Convert.getIntValue(idStudent));
        Mark mark = new Mark();
        mark.setCourse(course);
        mark.setStudent(student);
        return mark;
    }
}