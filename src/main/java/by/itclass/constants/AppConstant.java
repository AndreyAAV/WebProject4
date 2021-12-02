package by.itclass.constants;

public final class AppConstant {
    public static final String ID_LABEL = "id";
    public static final String LOGIN_LABEL = "login";
    public static final String PASSWORD_LABEL = "password";
    public static final String NAME_LABEL = "name";
    public static final String SURNAME_LABEL = "surname";
    public static final String EMAIL_LABEL = "email";
    public static final String SECTION_LABEL = "section";

    public static final String TITLE_LABEL = "title";
    public static final String SUBTITLE_LABEL = "subtitle";
    public static final String DESCRIPTION_LABEL = "description";
    public static final String DATE_LABEL = "date";
    public static final String PLACE_LABEL = "place";
    public static final String TYPE_LABEL = "type";

    public static final int CONFERENCE_TYPE = 0;
    public static final int TRAINING_TYPE = 1;
    public static final int LECTURE_TYPE = 2;


    public static final String LOGIN_JSP = "/login.jsp";
    public static final String REGISTRATION_JSP = "/registration.jsp";
    public static final String HOME_JSP = "/home.jsp";
    public static final String INDEX_JSP = "/index.jsp";
    public static final String COURSE_JSP = "/course.jsp";
    public static final String NEW_COURSE_JSP = "/new_course.jsp";

    public static final String AUTHORIZATION_CONT = "/authorization";
    public static final String REGISTRATION_CONT = "/registration";
    public static final String LOGOUT_CONT = "/logout";
    public static final String COURSE_LIST_CONT = "/course_list";
    public static final String COURSE_VIEW_CONT = "/course_view";
    public static final String COURSE_CREATE_CONT = "/course_create";

    public static final String MESSAGE_ATTR = "message";
    public static final String USER_ATTR = "user";
    public static final String COURSE_LIST_ATTR = "courses";
    public static final String COURSE_ATTR = "course";


    public static final String DAO_IMPL = "dao.impl";
    public static final String DAO_IN_MYSQL = "mysql";
    public static final String DAO_IN_MEMORY = "memory";

    public static final String INVALID_AUTHORIZATION_MESSAGE = "Incorrect login or password";
    public static final String INVALID_REGISTRATION_MESSAGE = "Such user already exists";
    public static final String COURSE_NOT_FOUND_MESSAGE = "Course with id not found";
    public static final String COURSE_IS_CREATE_MESSAGE = "Course is created";
    public static final String COURSE_IS_NOT_CREATE_MESSAGE = "Course is not created";

    public static final String DB_DRIVER = "driver";
    public static final String DB_URL = "url";

    public static final String DB_PROPERTY_FILE = "db.properties";
    public static final String APP_PROPERTY_FILE = "app.properties";

    public static final String DATE_PATTERN = "yyyy-MM-dd";
}
