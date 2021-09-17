package by.epam.training.course.filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import by.epam.training.course.entity.DBRole;

public class Permission {
    private static Map<String, Set<DBRole>> permissions = null;
    
    private Permission() {
        
    }
    
    private static void init() {
        permissions = new HashMap<>();
        Set<DBRole> all = new HashSet<>();
        all.addAll(Arrays.asList(DBRole.values()));
        Set<DBRole> teacher = new HashSet<>();
        teacher.add(DBRole.TEACHER);
        Set<DBRole> student = new HashSet<>();
        student.add(DBRole.STUDENT);
        
        permissions.put("/app/course/addstudent", student);
        permissions.put("/app/course/signup", student);
        permissions.put("/app/mycources", student);
        permissions.put("/app/mark", all);
        permissions.put("/app/teacher/addreview", teacher);
        permissions.put("/app/students", teacher);
    }
    
    public static Map<String, Set<DBRole>> getPermissions() {
        if (permissions == null) {
            synchronized (Permission.class) {
                if (permissions == null) {
                    init();
                }
            }
        }
        return permissions;
    }
}