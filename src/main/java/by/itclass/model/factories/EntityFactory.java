package by.itclass.model.factories;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.Course;
import by.itclass.model.entities.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class EntityFactory {

    public static Course getCourseEntity(Map<String, String[]> values) {
        final String METHOD_NAME = "setType";
        Class courseCl = Course.class;
        Course course = new Course();

        Set<String> fieldsNames = values.keySet();//InputName;[v1,v2,v3]
        //title->setTitle
        for (String name : fieldsNames) {
            try {
                Method method = courseCl.getDeclaredMethod(getSetMethodName(name), String.class);
                String value = values.get(name)[0];
                method.invoke(course, value);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    public static User createUser() {
        return null;
    }
    private static String getSetMethodName(String name) {
        final String PREFIX = "set";

        return PREFIX + name.substring(0,1).toUpperCase() + name.substring(1);
    }

}
