package by.epam.training.course.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.connection.ConnectionPool;
import by.epam.training.course.connection.DBConfig;
import by.epam.training.course.exception.PoolException;

public class ApplicationServletContextListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        DBConfig dbConfig = new DBConfig();
        dbConfig.setDriverName(sce.getServletContext().getInitParameter("driverName"));
        dbConfig.setInitPoolSize(Integer.parseInt(sce.getServletContext().getInitParameter("initPoolSize")));
        dbConfig.setMaxPoolSize(Integer.parseInt(sce.getServletContext().getInitParameter("maxPoolSize")));
        dbConfig.setUrl(sce.getServletContext().getInitParameter("dbUrl"));
        dbConfig.setUser(sce.getServletContext().getInitParameter("dbUser"));
        dbConfig.setPassword(sce.getServletContext().getInitParameter("dbPassword"));
        try {
            Class.forName(dbConfig.getDriverName());
        } catch (ClassNotFoundException e) {
            logger.fatal(String.format("Class \"%s\" not registered", dbConfig.getDriverName()));
        }
        ConnectionPool.init(dbConfig);
        logger.trace("********** POOL created *************");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        try {
            ConnectionPool.getInstance().destroy();
            logger.trace("********** POOL destroyed *************");
        } catch (PoolException | SQLException e) {
            logger.warn("************* ERROR destroy pool: " + e.getMessage());
        }
    }
}