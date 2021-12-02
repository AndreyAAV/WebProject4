package by.itclass.model.dao.impl;

import by.itclass.model.dao.interfaces.CourseDAO;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.db.SQLRequest;
import by.itclass.model.entities.Course;
import by.itclass.model.enums.Section;
import by.itclass.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCourseDAOImpl implements CourseDAO {
    private List<Course> getCourses(PreparedStatement pst) throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(SQLRequest.ID_COL);
            String title = rs.getString(SQLRequest.TITLE_COL);
            Date date = rs.getDate(SQLRequest.DATE_COL);
            int type = rs.getInt(SQLRequest.TYPE_COL);
            String author = rs.getString(SQLRequest.AUTHOR_COL);

            courses.add(new Course(id, title,  date, author, type));
        }
        return courses;
    }


    @Override
    public List<Course> getBySection(Section section) throws DAOException {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Course> courses = null;

        final String SQL_REQUEST = section.getSql();

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQL_REQUEST);
            courses = getCourses(pst);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

        return courses;
    }

    @Override
    public Course getById(int id) throws DAOException {


        Course course = null;

        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(SQLRequest.SELECT_COURSES_BY_ID)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String title = rs.getString(SQLRequest.TITLE_COL);
                String subtitle = rs.getString(SQLRequest.SUBTITLE_COL);
                String description = rs.getString(SQLRequest.DESCRIPTION_COL);
                Date date = rs.getDate(SQLRequest.DATE_COL);
                String place = rs.getString(SQLRequest.PLACE_COL);
                int type = rs.getInt(SQLRequest.TYPE_COL);
                boolean status = rs.getBoolean(SQLRequest.STATUS_COL);
                String author = rs.getString(SQLRequest.AUTHOR_COL);

                course = new Course(id, title, subtitle, description, date, place, author, status, type);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return course;
    }

    @Override
    public List<Course> getUserCourses(int idUser) throws DAOException {

        List<Course> courses = null;

        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(Section.USER_ID.getSql())) {;
            pst.setInt(1, idUser);
            courses = getCourses(pst);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }

        return courses;
    }

    @Override
    public boolean saveCourse(Course course, int idUser) throws DAOException {
        boolean isSave = false;
        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(SQLRequest.INSERT_NEW_COURSE)){

            pst.setInt(1, idUser);
            pst.setString(2, course.getTitle());
            pst.setInt(3, course.getType());
            pst.setString(4, course.getSubtitle());
            pst.setString(5, course.getDescription());
            pst.setDate(6, course.getDate());
            pst.setString(7, course.getPlace());
            pst.setBoolean(8, course.isStatus());

            isSave = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
        return isSave;
    }
}
