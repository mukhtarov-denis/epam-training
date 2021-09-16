package by.epam.training.course.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationSessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.trace("Session created ...");
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.trace("Session destroyed ...");
    }
}