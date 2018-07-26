package com.acoderx.webdemo.core;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by xudi on 2017/9/17.
 */
public abstract class AbstractSessionHandler implements SessionHandler {
    @Autowired
    private SessionService sessionService;

    @PostConstruct
    public void init() {
        if(isGet()){
            sessionService.registerGet(getApiId(),this);
        }
        if (isPost()) {
            sessionService.registerPost(getApiId(),this);
        }
    }

    public boolean isGet() {
        return false;
    }

    public boolean isPost() {
        return false;
    }

    @Override
    public boolean checkLogin() {
        return true;
    }

    @Override
    public boolean checkCsrf() {
        return true;
    }
}
