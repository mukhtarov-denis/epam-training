package by.epam.training.course.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer studentNumber;
    private Integer groupNumber;
    private List<Mark> marks = new ArrayList<>();
    
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
    
    public List<Mark> getMarks() {
        return marks;
    }
    
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
    
    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        return getId() == other.getId();
    }
}