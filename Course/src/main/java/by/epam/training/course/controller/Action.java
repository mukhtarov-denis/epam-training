package by.epam.training.course.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.service.ServiceFactory;

public abstract class Action {
    protected static final Logger logger = LogManager.getLogger();
    private ServiceFactory serviceFactory;
    
    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
    
    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }
    
    public abstract Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException;
}