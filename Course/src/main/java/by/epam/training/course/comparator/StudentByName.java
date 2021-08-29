package by.epam.training.course.comparator;

import java.util.Comparator;

import by.epam.training.course.entity.Student;

public class StudentByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname())
                + o1.getName().compareTo(o2.getName()
                + o1.getPatronymic().compareTo(o2.getPatronymic()));
    }
}