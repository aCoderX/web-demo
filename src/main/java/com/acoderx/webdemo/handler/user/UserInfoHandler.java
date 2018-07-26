package com.acoderx.webdemo.handler.user;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.acoderx.webdemo.bean.SessionBean;
import com.acoderx.webdemo.core.AbstractSessionHandler;
import com.acoderx.webdemo.utils.Apis;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/18.
 */
@Component
public class UserInfoHandler extends AbstractSessionHandler {
    @Override
    public ResponsePacket handle(HttpServletRequest request, HttpServletResponse response,SessionBean sessionBean) {
        if(sessionBean.getName().equals("xudi")){
            return ResponsePacket.success();
        }
        return ResponsePacket.failure("错误的name");
    }

    @Override
    public boolean isGet() {
        return true;
    }

    @Override
    public int getApiId() {
        return Apis.USER_INFO;
    }

}
