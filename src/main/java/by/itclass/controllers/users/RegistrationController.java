package by.itclass.controllers.users;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegistrationController", value = AppConstant.REGISTRATION_CONT)
public class RegistrationController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);
        String name = request.getParameter(AppConstant.NAME_LABEL);
        String surname = request.getParameter(AppConstant.SURNAME_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);

        try {
            User user = userService.registration(login, password, name, surname, email);
            if (Objects.nonNull(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(AppConstant.USER_ATTR, user);
                //отправить на LOGIN_JSP
                redirect(request, response, AppConstant.HOME_JSP);
            } else {
                jumpMessage(request, response, AppConstant.REGISTRATION_JSP, AppConstant.INVALID_REGISTRATION_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.REGISTRATION_JSP, e.getMessage());
        }
    }
}
