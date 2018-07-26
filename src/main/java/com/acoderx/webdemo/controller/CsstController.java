package com.acoderx.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by xudi on 2017/12/21.
 */
@Controller
public class CsstController {
    @RequestMapping(value = "/japi/session/csst/{id}",method = RequestMethod.GET)
    public String csst(HttpServletResponse response,@PathVariable String id) throws IOException {
        String s = "成功";
        response.setContentType("text/css");
        Writer out=response.getWriter();
        String result =
        "@keyframes a{"+
            "from{"+
            "}"+
            "to{"+
                "color: red;"+
            "}"+
        "}"+
        "#"+id+" {"+
            "content: '"+s+"';"+
            "animation: a 2s;"+
        "}";
        out.write(result);
        return null;
    }
}
