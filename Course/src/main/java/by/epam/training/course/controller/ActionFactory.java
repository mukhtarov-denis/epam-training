package by.epam.training.course.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import by.epam.training.course.controller.auth.LoginAction;
import by.epam.training.course.controller.auth.LogoutAction;
import by.epam.training.course.controller.course.CourseAction;
import by.epam.training.course.controller.course.CourseInfoAction;
import by.epam.training.course.controller.course.SignUpCourseAction;
import by.epam.training.course.controller.error.Error404Action;
import by.epam.training.course.controller.main.MainAction;
import by.epam.training.course.controller.mark.MarkAction;
import by.epam.training.course.controller.mark.SaveMarkAction;
import by.epam.training.course.controller.mark.SaveMarkValueAction;
import by.epam.training.course.controller.student.ViewCoursesAction;
import by.epam.training.course.controller.teacher.ViewStudentsAction;

public class ActionFactory {
    private static Map<String, Class<? extends Action>> actions = new HashMap<>();
    
    static {
        actions.put("/app", MainAction.class);
        actions.put("/app/course", CourseAction.class);
        actions.put("/app/course/info", CourseInfoAction.class);
        actions.put("/app/course/signup", SignUpCourseAction.class);            // need persmission
        actions.put("/app/course/addstudent", SaveMarkAction.class);            // need persmission 
        actions.put("/app/mycources", ViewCoursesAction.class);                 // need persmission
        actions.put("/app/mark", MarkAction.class);                             // need persmission
        actions.put("/app/students", ViewStudentsAction.class);                 // need permission
        actions.put("/app/teacher/addreview", SaveMarkValueAction.class);       // need permission
        actions.put("/app/login", LoginAction.class);
        actions.put("/app/logout", LogoutAction.class);
        actions.put("/app/error404", Error404Action.class);
    }
    
    public static Action getAction(String url) throws ServletException {
        Class<? extends Action> action = actions.get(url);
        try {
            if (action == null) {
                return actions.get("/app/error404").newInstance();
            }
            return action.newInstance();
        } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage(), e);
        }
    }
}