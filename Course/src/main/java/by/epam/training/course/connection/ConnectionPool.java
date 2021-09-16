package by.epam.training.course.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.exception.PoolException;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static ConnectionPool instance;
    private static int init_pool_size;
    private static int max_pool_size;
    private static int validationTimeOut;
    private static String url;
    private static String user;
    private static String password;
    private static int counter = 1;
    
    private List<Connection> freeConnections;
    private List<Connection> usedConnections;
    
    private ConnectionPool() throws SQLException {
        initPool();
    }
    
    private void initPool() throws SQLException {
        freeConnections = new ArrayList<Connection>();
        usedConnections = new ArrayList<Connection>();
        for (int i = 0; i < init_pool_size; i++) {
            freeConnections.add(createConnection());
        }
        logger.trace("Init pool success ...");
    }
    
    public void destroy() throws PoolException {
        freeConnections.addAll(usedConnections);
        usedConnections.clear();
        try {
            for (Connection connection : freeConnections) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.warn("Error destroy pool ...");
            throw new PoolException("Error destroy pool", e);
        } finally {
            freeConnections.clear();
            usedConnections = null;
            freeConnections = null;
            logger.trace("Pool destroyed success ...");
        }
    }
    
    public static void init(DBConfig dbConfig) {
        init_pool_size = dbConfig.getInitPoolSize();
        max_pool_size = dbConfig.getMaxPoolSize();
        validationTimeOut = dbConfig.getValidationTimeout();
        url = dbConfig.getUrl();
        user = dbConfig.getUser();
        password = dbConfig.getPassword();
    }
    
    
    public Connection getConnection() throws SQLException, PoolException {
        Connection connection = null;
        synchronized (freeConnections) {
            do {
                if (freeConnections.isEmpty()) {
                    if (getSize() < max_pool_size) {
                        connection = createConnection();
                    } else {
                        logger.error("Pool is full. Pool size = max pool size");
                        throw new PoolException("Pool is full", new Throwable("Pool size = max pool size"));
                    }
                } else {
                    connection = freeConnections.remove(freeConnections.size() - 1);
                    if (!connection.isValid(validationTimeOut)) {
                         connection.close();
                         connection = null;
                    }
                }
            } while (connection == null);
        }        
        usedConnections.add(connection);
        return connection;
    }
    
    public synchronized void releasedConnection(Connection connection) {
        usedConnections.remove(connection);
        freeConnections.add(connection);
    }
    
    public static ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }
    
    private Connection createConnection() throws SQLException {
        String connectionName = "connnection-" + counter++;
        return new PooledConnection(DriverManager.getConnection(url, user, password), connectionName);
    }
    
    private int getSize() {
        return freeConnections.size() + usedConnections.size();
    }
}