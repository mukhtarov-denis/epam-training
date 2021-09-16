package by.epam.training.course.comparator.filter;

import by.epam.training.course.entity.User;

public interface RoleFilter {
    boolean check(User user);
}