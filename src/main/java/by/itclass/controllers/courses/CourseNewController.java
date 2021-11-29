package by.itclass.controllers.courses;

import by.itclass.controllers.abstracts.AbstractController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourseNewController", value = "/CourseNewController")
public class CourseNewController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем параметры формы создания нового курса
        //и обращаемся к сервесу



    }
}
