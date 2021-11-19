package by.itclass.controllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AuthorizationController", value = AppConstant.AUTHORIZATION_CONT)
public class AuthorizationController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        try {
            User user = userService.authorization(login, password);

            if (Objects.nonNull(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(AppConstant.USER_ATTR, user);
                jump(request, response, AppConstant.HOME_JSP);
            } else {
                jumpMessage(request, response, AppConstant.LOGIN_JSP, AppConstant.INVALID_AUTHORIZATION_MESSAGE);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.LOGIN_JSP, e.getMessage());
        }
    }
}
