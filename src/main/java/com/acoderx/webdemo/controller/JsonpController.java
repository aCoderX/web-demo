package com.acoderx.webdemo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by xudi on 2017/12/21.
 */
@RestController
public class JsonpController {
    @RequestMapping(value = "/japi/session/jsonp",method = RequestMethod.GET)
    public String jsonp(){
        return "成功";
    }
}
