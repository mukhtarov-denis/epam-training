package by.epam.training.course.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationSessionAttributeListener implements HttpSessionAttributeListener {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeAdded(event);
        logger.trace("Added attribute to session ...");
    }
    
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
        logger.trace("Removed attribute from session ...");
    }
    
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
        logger.trace("Replaced attribute to session ...");
    }
}