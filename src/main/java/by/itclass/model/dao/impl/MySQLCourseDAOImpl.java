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

    @Override
    public List<Course> getBySection(Section section) throws DAOException {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Course> courses = new ArrayList<>();

        final String SQL_REQUEST = section.getSql();

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQL_REQUEST);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(SQLRequest.ID_COL);
                String title = rs.getString(SQLRequest.TITLE_COL);
                Date date = rs.getDate(SQLRequest.DATE_COL);
                int type = rs.getInt(SQLRequest.TYPE_COL);
                String author = rs.getString(SQLRequest.AUTHOR_COL);
                courses.add(new Course(id, title,  date, author, type));
            }
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
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Course course = null;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQLRequest.SELECT_COURSES_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

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
}
