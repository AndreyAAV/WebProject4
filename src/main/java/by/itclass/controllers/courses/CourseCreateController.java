package by.itclass.controllers.courses;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.User;
import by.itclass.model.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CourseCreateController", value = AppConstant.COURSE_CREATE_CONT)
public class CourseCreateController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем параметры формы создания нового курса
        //и обращаемся к сервесу
        Map<String, String[]> values = request.getParameterMap();
        //InputName;[v1,v2,v3]

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);

        try {
            if (courseService.saveCourse(values, user.getId())) {
                jumpMessage(request, response,
                        AppConstant.NEW_COURSE_JSP,
                        AppConstant.COURSE_IS_CREATE_MESSAGE);
            } else {
                jumpMessage(request, response,
                        AppConstant.NEW_COURSE_JSP,
                        AppConstant.COURSE_IS_NOT_CREATE_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response,
                    AppConstant.NEW_COURSE_JSP,

            e.getMessage());
        }


    }
}
