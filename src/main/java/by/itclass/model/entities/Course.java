package by.itclass.model.entities;

import by.itclass.constants.AppConstant;
import lombok.Data;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
    private List<Event> events;

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

    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(AppConstant.DATE_PATTERN);
        try {
            this.date = new Date(format.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Course(int id, String title, Date date, String author, int type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        setType(type);
    }

    public Course() {
    }

    public void setType(int ordinal) {
        this.type = Type.values()[ordinal];
    }

    public void setType(String ordinal) {
        setType(Integer.parseInt(ordinal));
    }


    public int getTypeOrdinal() {
        return type.ordinal();
    }

    private enum Type {
        CONFERENCE, TRAINING, LECTURE;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
