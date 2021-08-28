package by.epam.training.course.entity;

import java.io.Serializable;

public class Role extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}