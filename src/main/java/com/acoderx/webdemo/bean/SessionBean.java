package com.acoderx.webdemo.bean;

import java.io.Serializable;

/**
 * Created by xudi on 2017/9/18.
 */
public class SessionBean implements Serializable {
    private String name;
    private int age;
    private String sign;
    private long timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
