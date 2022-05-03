package com.example.ex0425;

public class ChatVO {
    private int imgId;
    private String name;
    private String msg;
    private String time;

    public ChatVO(){}

    public ChatVO(int imgId, String name, String msg, String time) {
        this.imgId = imgId;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
