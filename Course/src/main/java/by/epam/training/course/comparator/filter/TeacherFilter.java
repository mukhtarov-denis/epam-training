package by.epam.training.course.comparator.filter;

import by.epam.training.course.entity.DBRole;
import by.epam.training.course.entity.Role;
import by.epam.training.course.entity.User;

public class TeacherFilter implements RoleFilter {
        
    @Override
    public boolean check(User user) {
        for (Role role : user.getRoles()) {
            if (role.getId() == DBRole.TEACHER.getId()) {
                return true;
            }
        }
        return false;
    }
}