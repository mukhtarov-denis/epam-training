package by.epam.training.course.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Course extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Date startDate;
    private Date endDate;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    
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
    
    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    @Override
    public int hashCode() {
        return getId();
    }
    
    @Override
    public boolean equals(Object obj) {
        return getId() == ((Course) obj).getId();
    }
}