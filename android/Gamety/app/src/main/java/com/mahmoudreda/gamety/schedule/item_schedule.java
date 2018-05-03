package com.mahmoudreda.gamety.schedule;

/**
 * Created by mahmoud reda on 21/04/2018.
 */

public class item_schedule {
    private String time;
    private String hall;
    private String teacher_name;
    private String course_name;
    private String day;

    public void setTime(String time1) {
        this.time = time1;
    }

    void setHall(String hall1) {
        this.hall = hall1;
    }

    void setTeacher_name(String teacher_name1) {
        this.teacher_name = teacher_name1;
    }

    void setCourse_name(String course_name1) {
        this.course_name = course_name1;
    }

    void setDay(String day1) {
        this.day = day1;
    }

    public String getTime() {
        return time;
    }

    String getHall() {
        return hall;
    }

    String getTeacher_name() {
        return teacher_name;
    }

    String getCourse_name() {
        return course_name;
    }

    String getDay() {
        return day;
    }
}