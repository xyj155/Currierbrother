package com.example.currierbrother.bean;

public class Car {
    private int id;
    private String carnum;
    private String carmodel;
    private String carbelong;
private String carimg;

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getCarbelong() {
        return carbelong;
    }

    public void setCarbelong(String carbelong) {
        this.carbelong = carbelong;
    }
}
