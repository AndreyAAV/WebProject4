package by.itclass.controllers.users;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LogoutController", value = AppConstant.LOGOUT_CONT)
public class LogoutController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Удаление сессии
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);
        if (Objects.nonNull(user)) {
            session.invalidate();
        }
        redirect(request, response, AppConstant.LOGIN_JSP);

    }

}
