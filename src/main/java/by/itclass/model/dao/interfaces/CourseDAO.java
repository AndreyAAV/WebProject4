package by.itclass.model.dao.interfaces;

import by.itclass.model.entities.Course;
import by.itclass.model.enums.Section;
import by.itclass.model.exceptions.DAOException;

import java.util.List;

public interface CourseDAO {
    List<Course> getBySection(Section section) throws DAOException;
    Course getById(int id) throws DAOException;
    List<Course> getUserCourses(int idUser) throws DAOException;
    void saveCourse() throws DAOException;


}
