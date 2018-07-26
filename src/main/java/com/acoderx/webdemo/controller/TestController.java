package com.acoderx.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xudi on 2017/9/17.
 */
@Controller
public class TestController {
    @RequestMapping(value = "/japi/session/{id}/help",method = RequestMethod.GET)
    @ResponseBody
    public String help(@PathVariable int id){
        System.out.println(id);
        return "111中文";
    }
}
