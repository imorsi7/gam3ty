package com.mahmoudreda.gamety.dash_board;

public class item_Dash_Board {

    private String title;
    private String Desc;
    private String id;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setid(String id) {
        this.id = id;
    }

    void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getid() {
        return id;
    }

    String getDesc() {
        return Desc;
    }
}
