package by.itclass.model.dao.impl;

import by.itclass.model.dao.interfaces.UserDAO;
import by.itclass.model.db.InMemoryDB;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.DAOException;

public class InMemoryUserDAOImpl implements UserDAO {

    @Override
    public User get(String login, String password) throws DAOException {
        return InMemoryDB.selectUserByLoginAndPassword(login, password);
    }

    @Override
    public boolean save(User user, String password) throws DAOException {
        return false;
    }
}
