package com.mahmoudreda.gamety.course_content;

/**
 * Created by mahmoud reda on 01/06/2018.
 */

public class list_item_sch_doctor {
    private String course_name;
    private String year;
    private String hall;
    private String day;
    private String link;
    private String time;
    private String department;
    private String semester;



    public list_item_sch_doctor(String course_name, String year, String hall, String day, String time, String department, String semester,String link) {
        this.course_name = course_name;
        this.year = year;
        this.hall = hall;
        this.day = day;
        this.time = time;
        this.department = department;
        this.semester = semester;
        this.link = link;
    }



    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getDay() {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLink() {return link;}

    public void setLink(String link) {this.link = link;}
}
