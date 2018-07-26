package com.acoderx.webdemo.core;

import com.acoderx.webdemo.bean.ResponsePacket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/17.
 */
public interface SessionService {
    ResponsePacket get(int apiId, HttpServletRequest request, HttpServletResponse response);
    ResponsePacket post(int apiId, HttpServletRequest request, HttpServletResponse response);

    void registerGet(int apiId,SessionHandler handler);
    void registerPost(int apiId,SessionHandler handler);
}
