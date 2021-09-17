package by.epam.training.course.controller.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;

/*
 * Перенаправление на страницу 404.jsp
 */
public class Error404Action extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) {
        Forward forward = new Forward("/error/404", false);
        return forward;
    }
}