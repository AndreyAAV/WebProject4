package by.itclass.model.services;

import by.itclass.model.dao.interfaces.UserDAO;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.exceptions.ServiceException;
import by.itclass.model.factories.DAOFactory;

public class UserService {
    private UserDAO userDAO;
    private String oldDAO;

    public UserService() {
        oldDAO = new String();
    }

    public UserService(String dao) {
        userDAO = DAOFactory.getUserDAOInstance(dao);
        oldDAO = dao;
    }

    public void setUserDAO(String dao) {
        if (!dao.equals(oldDAO)) {
            userDAO = DAOFactory.getUserDAOInstance(dao);
        }
    }

    //Метод для доступа к model из controller-ов
    //вызывается при авторизации
    public User authorization(String login, String password) throws ServiceException {
        try {
            return userDAO.get(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public User registration(String login, String password, String name, String surname, String email) throws ServiceException {
        User user = new User(login, name, surname, email);
        try {
            //Если не сохранили пользователя
            if (!userDAO.save(user, password)) {
                user = null;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }
}
