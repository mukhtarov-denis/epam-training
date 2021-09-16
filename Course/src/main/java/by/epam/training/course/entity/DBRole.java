package by.epam.training.course.entity;

public enum DBRole {
    TEACHER,
    STUDENT;
    
    public int getId() {
        return ordinal() + 1;
    }
}