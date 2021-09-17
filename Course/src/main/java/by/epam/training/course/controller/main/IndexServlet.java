package by.epam.training.course.controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Перенаправление на главную страницу
 * */
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie langCookie = new Cookie("lang", "ru");
        resp.addCookie(langCookie);
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp");
        dispatcher.forward(req, resp);
    }
}