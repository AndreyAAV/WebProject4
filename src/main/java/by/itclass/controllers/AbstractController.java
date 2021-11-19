package by.itclass.controllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.properties.PropertyManager;
import by.itclass.model.services.CourseService;
import by.itclass.model.services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {
    protected UserService userService;
    protected CourseService courseService;
    private Properties properties;

    public AbstractController() {
        properties = PropertyManager.getProperties(AppConstant.APP_PROPERTY_FILE);
        userService = new UserService(properties.getProperty(AppConstant.DAO_IMPL));
        courseService = new CourseService(properties.getProperty(AppConstant.DAO_IMPL));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //properties = PropertyManager.getProperties(AppConstant.APP_PROPERTY_FILE);
        //userService.setUserDAO(properties.getProperty(AppConstant.DAO_IMPL));
        super.service(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void jumpMessage(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(AppConstant.MESSAGE_ATTR, message);
        jump(request, response, url);
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + url);
    }
}
