package by.itclass.model.enums;

import by.itclass.model.db.SQLRequest;

public enum Section {
    TODAY(SQLRequest.WHERE_TODAY),
    TOMORROW(SQLRequest.WHERE_TOMORROW),
    SOON(SQLRequest.WHERE_SOON),
    PAST(SQLRequest.WHERE_PAST),
    ALL(SQLRequest.WHERE_ALL);


    private String sql;

    Section(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return SQLRequest.SELECT_COURSES + sql;
        //select * from ... where ...
    }
}
