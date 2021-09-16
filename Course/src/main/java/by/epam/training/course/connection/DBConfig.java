package by.epam.training.course.connection;

public class DBConfig {
    private String driverName;
    private int initPoolSize;
    private int maxPoolSize;
    private int validationTimeout;
    private String url;
    private String user;
    private String password;
    
    public DBConfig() {
    
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public int getInitPoolSize() {
        return initPoolSize;
    }
    
    public void setInitPoolSize(int initPoolSize) {
        this.initPoolSize = initPoolSize;
    }
    
    public int getMaxPoolSize() {
        return maxPoolSize;
    }
    
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
    
    public int getValidationTimeout() {
        return validationTimeout;
    }
    
    public void setValidationTimeout(int validationTimeout) {
        this.validationTimeout = validationTimeout;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }   
}