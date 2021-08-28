package by.epam.training.course.entity;

import java.io.Serializable;

public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Course course;
    private Student student;
    private Integer value;
    private String review;
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
    
    public String getReview() {
        return review;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
}