package by.epam.training.course.controller.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;

public class LogoutAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        req.getSession().invalidate();
        Forward forward = new Forward("/app", true);
        return forward;
    }
}