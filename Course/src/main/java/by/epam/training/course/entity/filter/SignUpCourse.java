package by.epam.training.course.entity.filter;

import java.util.Calendar;

import by.epam.training.course.entity.Course;

public class SignUpCourse implements EntityFilter<Course> {

    @Override
    public boolean check(Course course) {
        return course.getStartDate().after(Calendar.getInstance().getTime());
    }
}