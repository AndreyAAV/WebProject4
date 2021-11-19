package by.itclass.model.services;

import by.itclass.model.dao.interfaces.CourseDAO;
import by.itclass.model.entities.Course;
import by.itclass.model.factories.DAOFactory;

import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService(String dao) {
        courseDAO = DAOFactory.getCourseDAOInstance(dao);
    }

    public List<Course> getBySection (String section) {
        //select * from c ALL
        return null;
    }
}
