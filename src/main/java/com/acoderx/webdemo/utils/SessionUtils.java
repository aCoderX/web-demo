package com.acoderx.webdemo.utils;

import com.acoderx.webdemo.bean.SessionBean;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

/**
 * Created by xudi on 2017/9/19.
 */
public class SessionUtils {
    private static final String SALT = "BJbjhVHJ";
    private static final String COOKIE_NAME = "TESTSESSION";
    public static SessionBean getSessionBean(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (COOKIE_NAME.equals(cookie.getName())) {
                String sessionValue = cookie.getValue();
                Map<String, Object> sessionMap = JsonUtils.toMap(sessionValue);

                if(NumberUtils.parseToLong(sessionMap.get("timestamp"))>new Date().getTime()){
                    SessionBean sessionBean = new SessionBean();
                    sessionBean.setName(StringUtils.toString(sessionMap.get("name")));
                    sessionBean.setAge(NumberUtils.parseToInt(sessionMap.get("age")));
                    sessionBean.setTimestamp(NumberUtils.parseToLong(sessionMap.get("timestamp")));
                    if (calculateSign(sessionBean).equals(StringUtils.toString(sessionMap.get("sign")))) {
                        return sessionBean;
                    }
                }
            }
        }
        return null;
    }

    public static void setSessionBean(HttpServletResponse response,SessionBean sessionBean) {
        sessionBean.setTimestamp(new Date().getTime()+30*1000*60);
        String sign = calculateSign(sessionBean);
        sessionBean.setSign(sign);
        Cookie cookie = new Cookie(COOKIE_NAME, JsonUtils.toString(sessionBean));
        response.addCookie(cookie);
    }

    public static String calculateSign(SessionBean sessionBean){
        String newstr= "";
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            String str = JsonUtils.toString(sessionBean) + SALT;
            newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newstr;
    }

}
