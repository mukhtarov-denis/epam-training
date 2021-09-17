package by.epam.training.course.controller.main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;

/*
 * Главная страница
 * */
public class MainAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Forward forward = new Forward("/index", false);
        return forward;
    }
}