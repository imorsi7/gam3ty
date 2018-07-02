package com.mahmoudreda.gamety.schedule;

/**
 * Created by mahmoud reda on 27/05/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class list_Item_sch {
    private String teacher_name;
    private String course_name;
    private String hall;
    private String day;
    private String time;

    list_Item_sch(String teacher_name, String course_name, String hall, String day, String time) {
        this.teacher_name = teacher_name;
        this.course_name = course_name;
        this.hall = hall;
        this.day = day;
        this.time = time;
    }

    String getTeacher_name() {
        return teacher_name;
    }

    void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
