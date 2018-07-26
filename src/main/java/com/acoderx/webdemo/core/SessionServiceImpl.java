package com.acoderx.webdemo.core;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.acoderx.webdemo.bean.SessionBean;
import com.acoderx.webdemo.utils.Errors;
import com.acoderx.webdemo.utils.SessionUtils;
import com.acoderx.webdemo.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xudi on 2017/9/17.
 */
@Service
public class SessionServiceImpl implements SessionService {

    private static Map<Integer, SessionHandler> GET_HANDLERS = new HashMap();
    private static Map<Integer, SessionHandler> POST_HANDLERS = new HashMap();

    public ResponsePacket get(int apiId, HttpServletRequest request, HttpServletResponse response) {
        if (apiId > 0) {
            SessionHandler handler = GET_HANDLERS.get(apiId);
//            SessionBean session = (SessionBean) request.getSession().getAttribute("session");
            SessionBean session = SessionUtils.getSessionBean(request);
            if (handler != null) {
                if (handler.checkLogin()) {
                    if (session == null || !checkSession(session)) {
                        return ResponsePacket.failure(Errors.NOPRAMITION);
                    }
                }
                /*if(handler.checkCsrf()){
                    String referer = request.getHeader("Referer");
                    if (handler.isPost() && !"localhost:8084".equals(referer)) {
                        return ResponsePacket.failure(Errors.NOPRAMITION);
                    }
                }*/
                return handler.handle(request, response, session);
            }
            return ResponsePacket.failure(Errors.NOPRAMITION);
        }
        return ResponsePacket.failure(Errors.ERRORAPIS);
    }

    public ResponsePacket post(int apiId, HttpServletRequest request, HttpServletResponse response) {
        if (apiId > 0) {
            SessionHandler handler = POST_HANDLERS.get(apiId);
//            SessionBean session = (SessionBean) request.getSession().getAttribute("session");
            SessionBean session = SessionUtils.getSessionBean(request);
            if (handler != null) {
                if (handler.checkLogin()) {
                    if (session == null || !checkSession(session)) {
                        return ResponsePacket.failure(Errors.NOPRAMITION);
                    }
                }
                /*if(handler.checkCsrf()){
                    String referer = request.getHeader("Referer");
                    if (handler.isPost() && !"localhost:8084".equals(referer)) {
                        return ResponsePacket.failure(Errors.NOPRAMITION);
                    }
                }*/
                return handler.handle(request, response, session);
            }
            return ResponsePacket.failure(Errors.NOPRAMITION);
        }
        return ResponsePacket.failure(Errors.ERRORAPIS);
    }

    public void registerGet(int apiId, SessionHandler handler) {
        GET_HANDLERS.put(apiId, handler);
    }

    public void registerPost(int apiId, SessionHandler handler) {
        POST_HANDLERS.put(apiId, handler);
    }

    private boolean checkSession(SessionBean sessionBean) {
        return sessionBean.getName().equals("xudi");
    }
}
