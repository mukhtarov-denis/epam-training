package by.epam.training.course.entity;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String post;
    private Course course;
    
    public String getPost() {
        return post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}