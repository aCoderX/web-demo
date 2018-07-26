package com.acoderx.webdemo.core;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.acoderx.webdemo.bean.SessionBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/17.
 */
public interface SessionHandler {
    ResponsePacket handle(HttpServletRequest request, HttpServletResponse response, SessionBean sessionBean);
    boolean isGet();
    boolean isPost();
    int getApiId();
    boolean checkLogin();
    boolean checkCsrf();
}
