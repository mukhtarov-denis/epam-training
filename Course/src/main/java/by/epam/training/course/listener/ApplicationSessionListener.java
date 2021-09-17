package by.epam.training.course.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.entity.user.UserContext;

public class ApplicationSessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.trace("Session created ...");
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        UserContext userContext = (UserContext) se.getSession().getAttribute("session_user_context");
        if (userContext != null) {
            logger.info(String.format("Logout user: \"%s\" ...", userContext.getPerson().getUser().getUsername()));
        }
        logger.trace("Session destroyed ...");
    }
}