package by.itclass.model.db;

public final class SQLRequest {
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD
        = "select * from users where login=? and password=?";
    public static final String INSERT_NEW_USER =
        "insert into users(login,password,name,surname,email) values(?,?,?,?,?)";

    public static final String ID_COL = "id";
    public static final String NAME_COL = "name";
    public static final String SURNAME_COL = "surname";
    public static final String EMAIL_COL = "email";

}
