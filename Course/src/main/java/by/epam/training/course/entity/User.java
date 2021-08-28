package by.epam.training.course.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Date expireDate;
    private Set<Role> roles = new HashSet<>();
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getExpireDate() {
        return expireDate;
    }
    
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}