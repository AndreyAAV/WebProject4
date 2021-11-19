package by.itclass.model.dao.impl;

import by.itclass.model.dao.interfaces.UserDAO;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.db.SQLRequest;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.DAOException;

import java.sql.*;

//Реализовать класс дома
public class MySQLUserDAOImpl implements UserDAO {
    @Override
    public User get(String login, String password) throws DAOException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        User user = null;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQLRequest.SELECT_USER_BY_LOGIN_AND_PASSWORD);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(SQLRequest.ID_COL);
                String name = rs.getString(SQLRequest.NAME_COL);
                String surname = rs.getString(SQLRequest.SURNAME_COL);
                String email = rs.getString(SQLRequest.EMAIL_COL);
                user = new User(id, login, name, surname, email);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
        return user;
    }

    @Override
    public boolean save(User user, String password) throws DAOException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean isSave = false;

        try {
            cn = ConnectionManager.getConnection();
            //Установка параметра Statement.RETURN_GENERATED_KEYS
            //позволяет затем получить сгенерированные ключи(ID)
            pst = cn.prepareStatement(SQLRequest.INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getLogin());
            pst.setString(2, password);
            pst.setString(3, user.getName());
            pst.setString(4, user.getSurname());
            pst.setString(5, user.getEmail());

            isSave = pst.executeUpdate() > 0;
            if (isSave) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setId(id);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            isSave = false;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
        return isSave;
    }
}
