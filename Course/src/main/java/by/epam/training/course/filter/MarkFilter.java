package by.epam.training.course.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.epam.training.course.entity.DBRole;
import by.epam.training.course.entity.user.UserContext;
import by.epam.training.course.util.Convert;

/*
 * фильтр для просмотра / выставления оценки
 * студент может посмотреть только свою отметку
 * преподаватель может выставить только по своему предмету
 */
public class MarkFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserContext userContext = (UserContext) httpRequest.getSession().getAttribute("session_user_context");
        DBRole role = (DBRole) httpRequest.getAttribute("role");
        Integer idTeacher = Convert.getIntValue(httpRequest.getParameter("idTeacher"));
        Integer idStudent = Convert.getIntValue(httpRequest.getParameter("idStudent"));
        boolean isError = false;
        if (role == DBRole.STUDENT) {
            if (idStudent != userContext.getPerson().getUser().getId()) {
                request.setAttribute("errorMessage", "student.messages.error.owner");
                isError = true;
            }
            request.setAttribute("hiddenIfStudent", "hidden");
            request.setAttribute("readOnlyIfStudent", "readonly");
        } else if (role == DBRole.TEACHER) {
            if (idTeacher != userContext.getPerson().getUser().getId()) {
                request.setAttribute("errorMessage", "teacher.messages.error.owner");
                isError = true;
            }
        }
        if (isError) {
            request.getRequestDispatcher("/WEB-INF/view/mark/mark.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}