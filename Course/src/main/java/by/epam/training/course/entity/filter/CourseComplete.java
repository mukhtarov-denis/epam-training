package by.epam.training.course.entity.filter;

import java.util.Calendar;

import by.epam.training.course.entity.Course;

public class CourseComplete implements EntityFilter<Course> {

    @Override
    public boolean check(Course course) {
        return course.getEndDate().before(Calendar.getInstance().getTime());
    }
}