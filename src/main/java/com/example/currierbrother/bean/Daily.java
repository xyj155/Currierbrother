package com.example.currierbrother.bean;

import java.util.Date;

public class Daily {
    private Integer id;

    private Integer num;

    private Date date;

    private String latintude;

    private String longtitude;

    private String user;

    private Integer servicetime;

    private Integer endtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLatintude() {
        return latintude;
    }

    public void setLatintude(String latintude) {
        this.latintude = latintude == null ? null : latintude.trim();
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude == null ? null : longtitude.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getServicetime() {
        return servicetime;
    }

    public void setServicetime(Integer servicetime) {
        this.servicetime = servicetime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }
}