package by.itclass.controllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCourseController", value = "/ListCourseController")
public class ListCourseController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String section = request.getParameter(AppConstant.SECTION_LABEL);
        //today, ....

        List<Course> courses = courseService.getBySection(section);


    }
}
