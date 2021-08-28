package by.epam.training.course.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Course extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Date startDate;
    private Date endDate;
    private Teacher teacher;
    private Set<Student> students;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Set<Student> getStudents() {
        return students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}