package by.itclass.model.db;

public final class SQLRequest {
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD
        = "select * from users where login=? and password=?";
    public static final String INSERT_NEW_USER =
        "insert into users(login,password,name,surname,email) values(?,?,?,?,?)";

    public static final String SELECT_COURSES_BY_ID =
            "select title, " +
                    "type, " +
                    "subtitle, " +
                    "description, " +
                    "date, " +
                    "place, " +
                    "status, " +
                    "concat_ws(' ', users.surname, users.name) as author " +
                    "from courses " +
                    "left join users on users.id=courses.idUser " +
                    "where courses.id=?";


    public static final String SELECT_COURSES =
            "select courses.id, " +
            "title, " +
            "type, " +
            "date, " +
            "concat_ws(' ', users.surname, users.name) as author " +
            "from courses " +
            "left join users on users.id=courses.idUser ";

    public static final String WHERE_TODAY = "where date=curdate()";
    public static final String WHERE_TOMORROW = "where date=date_add(curdate(), interval 1 day)";
    public static final String WHERE_SOON = "where date>date_add(curdate(), interval 1 day)";
    public static final String WHERE_PAST = "where date<curdate()";
    public static final String WHERE_ALL = "";
    public static final String WHERE_USER_ID = "where idUser=?";

    public static final String ID_COL = "id";
    public static final String NAME_COL = "name";
    public static final String SURNAME_COL = "surname";
    public static final String EMAIL_COL = "email";

    public static final String TITLE_COL = "title";
    public static final String TYPE_COL = "type";
    public static final String SUBTITLE_COL = "subtitle";
    public static final String DESCRIPTION_COL = "description";
    public static final String DATE_COL = "date";
    public static final String PLACE_COL = "place";
    public static final String STATUS_COL = "status";
    public static final String AUTHOR_COL = "author";

}
