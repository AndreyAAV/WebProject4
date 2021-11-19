package by.itclass.model.dao.interfaces;

import by.itclass.model.entities.User;
import by.itclass.model.exceptions.DAOException;

public interface UserDAO {
    //Метод вызывается при авторизации в системе
    User get(String login, String password) throws DAOException;
    boolean save(User user, String password) throws DAOException;
}
