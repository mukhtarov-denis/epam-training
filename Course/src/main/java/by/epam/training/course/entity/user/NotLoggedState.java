package by.epam.training.course.entity.user;

import by.epam.training.course.entity.DBRole;

public class NotLoggedState implements UserState {

    @Override
    public DBRole getRole() {
        return null;
    }

    @Override
    public void setState(UserContext context) {
        context.setStudent(false);
        context.setTeacher(false);
        context.setNotLogged(true);
    }
}