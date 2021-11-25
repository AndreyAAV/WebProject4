package by.itclass.controllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.Course;
import by.itclass.model.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "CourseViewController", value = AppConstant.COURSE_VIEW_CONT)
public class CourseViewController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);

        try {
            Course course = courseService.getById(id);
            if (Objects.nonNull(course)) {
                request.setAttribute(AppConstant.COURSE_ATTR, course);
                jump(request, response, AppConstant.COURSE_JSP);
            } else {
                jumpMessage(request, response, AppConstant.INDEX_JSP, AppConstant.COURSE_NOT_FOUND_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.INDEX_JSP, e.getMessage());
        }

    }
}
