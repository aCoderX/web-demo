package com.acoderx.webdemo.utils;

/**
 * Created by xudi on 2017/8/5.
 */
public class StringUtils {
    public static final String EMPTY="";
    public static boolean isNotEmpty(String... ss) {
        for (String s : ss) {
            if(s==null||s.length()==0){
                return false;
            }
        }
        return true;
    }
    public static boolean isEmpty(String... ss) {
        return !isNotEmpty(ss);
    }

    public static String toString(Object o) {
        if (o != null) {
            return o.toString();
        }
        return "";
    }

    public static String nullToDefault(String s,String def){
        return s != null ? s : def;
    }

    public static String nullToEmpty(String s){
        return nullToDefault(s,EMPTY);

    }
}
