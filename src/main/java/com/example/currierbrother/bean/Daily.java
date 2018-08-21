//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.currierbrother.bean;

import java.util.Date;

public class Daily {
    private Integer id;
    private String ordernum;
    private Date date;
    private double latintude;
    private double longtitude;

    @Override
    public String toString() {
        return "Daily{" +
                "id=" + id +
                ", ordernum='" + ordernum + '\'' +
                ", date=" + date +
                ", latintude=" + latintude +
                ", longtitude=" + longtitude +
                ", username='" + username + '\'' +
                ", servicetime=" + servicetime +
                ", endtime=" + endtime +
                ", startlocation='" + startlocation + '\'' +
                ", endlocation='" + endlocation + '\'' +
                ", tel='" + tel + '\'' +
                ", pid=" + pid +
                '}';
    }

    private String username;
    private Integer servicetime;
    private Integer endtime;
    private String startlocation;
    private String endlocation;
    private String tel;
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Daily() {
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernum() {
        return this.ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLatintude() {
        return this.latintude;
    }

    public void setLatintude(double latintude) {
        this.latintude = latintude;
    }

    public double getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getServicetime() {
        return this.servicetime;
    }

    public void setServicetime(Integer servicetime) {
        this.servicetime = servicetime;
    }

    public Integer getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public String getStartlocation() {
        return this.startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation == null ? null : startlocation.trim();
    }

    public String getEndlocation() {
        return this.endlocation;
    }

    public void setEndlocation(String endlocation) {
        this.endlocation = endlocation == null ? null : endlocation.trim();
    }
}
