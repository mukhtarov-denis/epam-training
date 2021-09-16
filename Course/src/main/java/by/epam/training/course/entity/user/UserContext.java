package by.epam.training.course.entity.user;

import by.epam.training.course.entity.Person;
import by.epam.training.course.entity.User;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
/*
 * Класс с флагами для состояния пользователя при авторизации
 * 1. студент
 * 2. преподаватель
 * 3. не авторизован
 */
public class UserContext {
    private UserState state;
    private Person person;
    private boolean student;
    private boolean teacher;
    private boolean notLogged;
    
    public UserContext(User user) {
        person = new Person();
        person.setUser(user);
    }
    
    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public boolean isNotLogged() {
        return notLogged;
    }

    public void setNotLogged(boolean notLogged) {
        this.notLogged = notLogged;
    }

    public void define() throws ServiceException, ServiceFactoryException {
        state.setState(this);
    }
}