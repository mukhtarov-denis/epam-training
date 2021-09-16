package by.epam.training.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.service.ServiceFactory;
import by.epam.training.course.service.impl.ServiceFactoryImpl;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public ServiceFactory getServiceFactory() {
        return new ServiceFactoryImpl();
    }
    
    @Override
    public void init() throws ServletException {
        logger.info("INIT Dispatcher servlet");
    }
    
    @Override
    public void destroy() {
        logger.info("DESTROY Dispatcher servlet");
    }
    
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String context = req.getContextPath();
        String urlApplication = url.substring(context.length());
        ServiceFactory serviceFactory = getServiceFactory();
        Action action = ActionFactory.getAction(urlApplication);
        action.setServiceFactory(serviceFactory);
        Forward forward = action.execute(req, resp);
        if (forward != null) {
            if (forward.isRedirect()) {
                resp.sendRedirect(context + forward.getUrl());
            } else {
                req.getRequestDispatcher("/WEB-INF/view" + forward.getUrl() + ".jsp").forward(req, resp);            
            }
        } else {
            String message = "Forward is null, CONTEXT: " + context + ", URL: " + url;
            logger.error(message);
            throw new ServletException(message);
        }
    }
}