package by.epam.training.course.controller.mark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.entity.user.UserContext;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.Convert;

/*
 * Выставление оценок
 * createMark формирует mark для обновления
 * при успешном обновлении redirect на страницу выставления оценки 
 * */
public class SaveMarkValueAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        UserContext userContext = (UserContext) req.getSession().getAttribute("session_user_context");
        Mark mark = createMark(req);
        if (mark.getCourse().getId() != null && mark.getStudent().getId() != null) {
            try {
                getServiceFactory().getMarkService().update(mark);
            } catch (ServiceException | ServiceFactoryException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error update entity \"mark\" into table \"mark\"");
                sb.append("idCourse=").append(mark.getCourse().getId());
                sb.append("idStudent=").append(mark.getStudent().getId());
                logger.error(sb.toString());
                throw new ServletException(sb.toString(), e);
            }
            String url = "/app/mark?idCourse=" + mark.getCourse().getId() 
                                  + "&idStudent=" + mark.getStudent().getId()
                                  + "&idTeacher=" + userContext.getPerson().getUser().getId()
                                  + "&infoMessage=teacher.messages.mark_update";
            Forward forward = new Forward(url, true);
            return forward;
        } else {
            throw new IllegalArgumentException("exception.incorrect_values");
        }
    }
        
    private Mark createMark(HttpServletRequest req) {
        String idCourse = req.getParameter("idCourse");
        String idStudent = req.getParameter("idStudent");
        String markValue = req.getParameter("mark");
        System.out.println("Mark is : \"" + markValue + "\"");
        String review = req.getParameter("review");
        Course course = new Course();
        course.setId(Convert.getIntValue(idCourse));
        Student student = new Student();
        student.setId(Convert.getIntValue(idStudent));
        Mark mark = new Mark();
        mark.setCourse(course);
        mark.setStudent(student);
        mark.setValue(Convert.getIntValue(markValue));
        mark.setReview("".equals(review) ? null : review);
        return mark;
    }
}