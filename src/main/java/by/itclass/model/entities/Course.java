package by.itclass.model.entities;

import lombok.Data;

import java.sql.Date;
import java.util.Locale;

@Data
public class Course {

    private int id;
    private String title;
    private String subtitle;
    private String description;
    private Date date;
    private String place;
    private String author;
    private boolean status;
    private Type type;

    public Course(int id, String title, String subtitle, String description, Date date, String place, String author, boolean status, int type) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.date = date;
        this.place = place;
        this.author = author;
        this.status = status;
        setType(type);
    }

    public Course(int id, String title, Date date, String author, int type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        setType(type);
    }

    public void setType(int type) {
        this.type = Type.values()[type];
    }


    private enum Type {
        CONFERENCE, TRAINING, LECTURE;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
