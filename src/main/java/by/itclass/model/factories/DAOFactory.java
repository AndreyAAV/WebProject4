package by.itclass.model.factories;

import by.itclass.constants.AppConstant;
import by.itclass.model.dao.impl.InMemoryUserDAOImpl;
import by.itclass.model.dao.impl.MySQLCourseDAOImpl;
import by.itclass.model.dao.impl.MySQLUserDAOImpl;
import by.itclass.model.dao.interfaces.CourseDAO;
import by.itclass.model.dao.interfaces.UserDAO;

public class DAOFactory {
    public static UserDAO getUserDAOInstance(String dao) {
        UserDAO userDAO = null;
        switch (dao.toLowerCase()) {
            case AppConstant.DAO_IN_MEMORY :
                userDAO = new InMemoryUserDAOImpl();
                break;
            case AppConstant.DAO_IN_MYSQL :
                userDAO = new MySQLUserDAOImpl();
                break;
        }
        return userDAO;
    }

    public static CourseDAO getCourseDAOInstance (String dao) {
        CourseDAO courseDAO = null;
        switch (dao.toLowerCase()) {
            case AppConstant.DAO_IN_MEMORY :
                //courseDAO = new InMemoryUserDAOImpl();
                break;
            case AppConstant.DAO_IN_MYSQL :
                courseDAO = new MySQLCourseDAOImpl();
                break;
        }
        return courseDAO;
    }

}
