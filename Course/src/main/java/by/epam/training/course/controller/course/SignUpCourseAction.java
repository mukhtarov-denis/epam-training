package by.epam.training.course.controller.course;

import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.comparator.StudentByName;
import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.user.UserContext;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.Convert;

/*
 * Определяет возможно ли студенту записаться на курс (флаг canSignUp)
 * а также содержит сообщение (message), если студент записался на курс
 * или уже записан
 * idStudent берем из состояния UserContext
 */
public class SignUpCourseAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        UserContext userContext = (UserContext) req.getSession().getAttribute("session_user_context");
        Integer idCourse = Convert.getIntValue(req.getParameter("idCourse"));
        if (idCourse != null) {
            Course course = null;
            Student student = null;
            boolean canSignUp = true;
            String message = "";
            String userMessage = "student.messages.question_signup";
            try {
                course = getServiceFactory().getCourseService().find(idCourse);
                Collections.sort(course.getStudents(), new StudentByName());
                student = getServiceFactory().getStudentService().find(userContext.getPerson().getUser().getId());
                if (course.getStudents().contains(student)) {
                    canSignUp = false;
                    message = "student.messages.signup";
                }
            } catch (ServiceException | ServiceFactoryException e) {
                String catchMessage = String.format("Error get course/student for idCourse=%d, idStudent=%d", 
                                                     idCourse, userContext.getPerson().getUser().getId());
                logger.error(catchMessage);
                throw new ServletException(catchMessage, e);
            }
            req.setAttribute("canSignUp", canSignUp);
            req.setAttribute("message", message);
            req.setAttribute("userMessage", userMessage);
            req.setAttribute("student", student);
            req.setAttribute("course", course);
            Forward forward = new Forward("/course/signup_course", false);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.incorrect_values");
        }
    }
}