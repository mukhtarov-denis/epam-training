package by.epam.training.course.entity.filter;

import by.epam.training.course.entity.Entity;

public interface EntityFilter<T extends Entity> {
    boolean check(T entity);
}