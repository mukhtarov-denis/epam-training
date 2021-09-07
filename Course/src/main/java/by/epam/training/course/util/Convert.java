package by.epam.training.course.util;

public final class Convert {

    public static final Integer getIntValue(String value) {
        Integer result = null;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {}
        return result;
    }
}