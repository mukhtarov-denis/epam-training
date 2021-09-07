package by.epam.training.course.entity.filter;

import by.epam.training.course.entity.Entity;

public interface Filter<T extends Entity> {
    boolean check(T entity);
}