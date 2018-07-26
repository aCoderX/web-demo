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
public class PostTestHandler1 extends AbstractSessionHandler {
    public ResponsePacket handle(HttpServletRequest request, HttpServletResponse response, SessionBean sessionBean) {
        System.out.println("删库啊啊啊");
        return ResponsePacket.success("成功");
    }

    public int getApiId() {
        return 30001;
    }

    @Override
    public boolean isPost() {
        return true;
    }

    @Override
    public boolean checkLogin() {
        return false;
    }
}
