package com.acoderx.webdemo.handler.user;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.acoderx.webdemo.bean.SessionBean;
import com.acoderx.webdemo.core.AbstractSessionHandler;
import com.acoderx.webdemo.utils.Apis;
import com.acoderx.webdemo.utils.SessionUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/17.
 */
@Component
public class LoginHandler extends AbstractSessionHandler {
    public ResponsePacket handle(HttpServletRequest request, HttpServletResponse response, SessionBean sessionBean) {
        sessionBean = new SessionBean();
        sessionBean.setAge(18);
        sessionBean.setName("xudi");
//        request.getSession().setAttribute("session",sessionBean);
        SessionUtils.setSessionBean(response, sessionBean);
        return ResponsePacket.success();
    }

    public int getApiId() {
        return Apis.LOGIN;
    }

    @Override
    public boolean isGet() {
        return true;
    }

    @Override
    public boolean checkLogin() {
        return false;
    }
}
