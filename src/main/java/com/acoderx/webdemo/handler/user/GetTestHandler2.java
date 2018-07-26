package com.acoderx.webdemo.handler.user;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.acoderx.webdemo.bean.SessionBean;
import com.acoderx.webdemo.core.AbstractSessionHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/17.
 */
@Component
public class GetTestHandler2 extends AbstractSessionHandler {
    public ResponsePacket handle(HttpServletRequest request, HttpServletResponse response,SessionBean sessionBean) {
        return ResponsePacket.success("成功");
    }

    public int getApiId() {
        return 20002;
    }

    @Override
    public boolean isGet() {
        return true;
    }

    @Override
    public boolean checkLogin() {
        return true;
    }
}
