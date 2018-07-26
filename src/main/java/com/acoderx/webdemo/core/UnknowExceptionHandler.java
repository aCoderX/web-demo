package com.acoderx.webdemo.core;

import com.acoderx.webdemo.utils.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xudi on 2017/9/17.
 */
@ControllerAdvice
@ResponseBody
public class UnknowExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String noKnowEception(Exception e) {
        e.printStackTrace();
        return Errors.UNKNOW;
    }
}
