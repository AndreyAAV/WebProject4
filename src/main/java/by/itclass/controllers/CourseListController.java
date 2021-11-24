package by.itclass.controllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.Course;
import by.itclass.model.exceptions.ServiceException;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseListController", value = AppConstant.COURSE_LIST_CONT)
public class CourseListController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String section = request.getParameter(AppConstant.SECTION_LABEL);
        //today, ....

        try {
            List<Course> courses = courseService.getBySection(section);
            request.setAttribute(AppConstant.COURSE_LIST_ATTR, courses);
            jump(request, response, AppConstant.INDEX_JSP);
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.INDEX_JSP, e.getMessage());
        }



    }
}
