package by.itclass.model.services;

import by.itclass.model.dao.interfaces.CourseDAO;
import by.itclass.model.entities.Course;
import by.itclass.model.enums.Section;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.exceptions.ServiceException;
import by.itclass.model.factories.DAOFactory;
import by.itclass.model.factories.SectionFactory;

import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService(String dao) {
        courseDAO = DAOFactory.getCourseDAOInstance(dao);
    }

    public List<Course> getBySection (String section) throws ServiceException {
        //select * from c ALL
        Section sect = SectionFactory.getKindSectionMenu(section);
        try {
            return courseDAO.getBySection(sect);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }

    }
}
