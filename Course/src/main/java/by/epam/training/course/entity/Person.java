package by.epam.training.course.entity;

import java.sql.Date;

public class Person extends Entity {
    private String surname;
    private String name;
    private String patronymic;
    private Date bornDate;
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPatronymic() {
        return patronymic;
    }
    
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    public Date getBornDate() {
        return bornDate;
    }
    
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }  
}