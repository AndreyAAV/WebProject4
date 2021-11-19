package by.itclass.model.dao.interfaces;

import by.itclass.model.entities.Course;
import by.itclass.model.exceptions.DAOException;

import java.util.List;

public interface CourseDAO {
    List<Course> getAll() throws DAOException;

}
