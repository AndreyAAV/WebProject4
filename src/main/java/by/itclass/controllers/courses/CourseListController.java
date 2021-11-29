package by.itclass.controllers.courses;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.Course;
import by.itclass.model.entities.User;
import by.itclass.model.enums.Section;
import by.itclass.model.exceptions.ServiceException;
import by.itclass.model.factories.SectionFactory;

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

        Section sect = SectionFactory.getKindSectionMenu(section);
        List<Course> courses = null;
        String next = AppConstant.INDEX_JSP;
        try {
            if (sect == Section.USER_ID) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute(AppConstant.USER_ATTR);
                courses = courseService.getUserCourses(user.getId());
                next = AppConstant.HOME_JSP;
            } else {
                courses = courseService.getBySection(sect);
            }

            request.setAttribute(AppConstant.COURSE_LIST_ATTR, courses);
            jump(request, response, next);
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.INDEX_JSP, e.getMessage());
        }



    }
}
