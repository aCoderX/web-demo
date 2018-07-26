package com.acoderx.webdemo.utils;

/**
 * Created by xudi on 2017/8/5.
 */
public class NumberUtils {
    public static int parseToInt(Object o){
        return Integer.valueOf(o.toString());
    }
    public static long parseToLong(Object o){
        return Long.valueOf(o.toString());
    }
}
