package com.acoderx.webdemo.core;

import com.acoderx.webdemo.controller.JsonpController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by xudi on 2017/12/21.
 */
@ControllerAdvice(basePackageClasses = JsonpController.class)
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback");
    }
}
