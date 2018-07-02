package com.mahmoudreda.gamety.course_content;

/**
 * Created by mahmoud reda on 01/06/2018.
 */

class list_item_course_student {

    private String course_name_student;
    private String link_student;

   public String getCourse_name_student() {
        return course_name_student;
    }

    void setCourse_name_student(String course_name_student) {
        this.course_name_student = course_name_student;
    }

    public String getLink_student() {
        return link_student;
    }

    public void setLink_student(String link_student) {
        this.link_student = link_student;
    }

    list_item_course_student(String course_name, String course_link) {
       this.course_name_student=course_name;
       this.link_student=course_link;

    }
}
