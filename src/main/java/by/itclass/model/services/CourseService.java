package by.itclass.model.services;

import by.itclass.model.dao.interfaces.CourseDAO;
import by.itclass.model.entities.Course;
import by.itclass.model.enums.Section;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.exceptions.ServiceException;
import by.itclass.model.factories.DAOFactory;
import by.itclass.model.factories.EntityFactory;
import by.itclass.model.factories.SectionFactory;

import java.util.List;
import java.util.Map;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService(String dao) {
        courseDAO = DAOFactory.getCourseDAOInstance(dao);
    }

    public List<Course> getBySection (Section section) throws ServiceException {
        //select * from c ALL
        try {
            return courseDAO.getBySection(section);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }

    public Course getById(String id) throws ServiceException {
        try {
            int courseId = Integer.parseInt(id);
            return courseDAO.getById(courseId);
        } catch (DAOException | NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<Course> getUserCourses(int idUser) throws ServiceException {
        try {
            return courseDAO.getUserCourses(idUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    //InputName;[v1,v2,v3]
    public boolean saveCourse(Map<String, String[]> values, int idUser) throws ServiceException {
        Course course = EntityFactory.getCourseEntity(values);
        try {
            return courseDAO.saveCourse(course, idUser);
        } catch (DAOException e) {
            e.printStackTrace();
            throw  new ServiceException(e);
        }

    }
}
