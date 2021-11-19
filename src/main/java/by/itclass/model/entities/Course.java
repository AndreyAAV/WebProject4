package by.itclass.model.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class Course {
    private int id;
    private String title;
    private String subtitle;
    private String description;
    private Date date;
    private String place;
    private String author;
    private Status status;
    private Type type;

}
