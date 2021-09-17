package by.epam.training.course.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.entity.user.UserContext;

public class ApplicationSessionAttributeListener implements HttpSessionAttributeListener {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        UserContext userContext = (UserContext) event.getSession().getAttribute("session_user_context");
        if (userContext != null) {
            logger.info(String.format("User: \"%s\" signup ...", userContext.getPerson().getUser().getUsername()));
        }
    }
    
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        
    }
    
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    
    }
}