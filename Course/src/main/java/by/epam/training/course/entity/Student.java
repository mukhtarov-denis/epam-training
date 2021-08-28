package by.epam.training.course.entity;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer studentNumber;
    private Integer groupNumber;
    
    public Integer getStudentNumber() {
        return studentNumber;
    }
    
    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    public Integer getGroupNumber() {
        return groupNumber;
    }
    
    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }
}