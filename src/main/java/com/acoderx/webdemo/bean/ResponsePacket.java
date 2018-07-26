package com.acoderx.webdemo.bean;

import com.acoderx.webdemo.utils.StringUtils;

import java.io.Serializable;

/**
 * Created by xudi on 2017/9/17.
 */
public class ResponsePacket implements Serializable {
    private String message;
    private boolean success;
    public ResponsePacket(){}
    public ResponsePacket(boolean success){
        this.success = success;
    }
    public static ResponsePacket failure(String message){
        ResponsePacket packet = new ResponsePacket(false);
        packet.setMessage(message);
        return packet;
    }
    public static ResponsePacket success(String message){
        ResponsePacket packet = new ResponsePacket(true);
        packet.setMessage(message);
        return packet;
    }
    public static ResponsePacket success(){
        return success(StringUtils.EMPTY);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
