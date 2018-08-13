package com.example.currierbrother.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */

public class VRP {

    /**
     * code : 200
     * data : [["92","58","64","63","29","27","33","91","78"],["5","13","76","39","44","18","96","79","41","68","93"],["4","50","6","84","32","53"],["86","10","88","23","28","69","0","71","89","77","52"],["37","51","67","73","34","90","35","66","12"],["16","1","60","75","7","38","3","82"],["65","80","54","94","97","57","42","85"],["62","14","55","83","45"],["81","36","48","98","72"],["87","70","2","47"],["26","49"],["9","11","8"],["17"],["25"],["20","21"],["59","74","99"],["46"],["19","22"],["43","30"],["95"],["24","61","31"],["15","40"],["56"]]
     * success : true
     */

    private String code;
    private String success;
    private List<List<String>> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
