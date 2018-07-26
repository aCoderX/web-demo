package com.acoderx.webdemo.core;

import com.acoderx.webdemo.bean.ResponsePacket;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xudi on 2017/9/17.
 */
@RestController
@RequestMapping(value = "/japi/session")
public class SessionController extends BaseController {
    @Autowired
    private SessionService sessionService;

    @CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET})
    @RequestMapping(value = "/cors/{id}", method = RequestMethod.GET)
    public ResponsePacket getCors(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        /*response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET");*/
        return sessionService.get(id, request, response);
    }

    @CrossOrigin(origins = "*", maxAge = 3600,methods = {RequestMethod.GET})
    @RequestMapping(value = "/cors/preflight/{id}", method = RequestMethod.GET)
    public ResponsePacket getPreflightCors(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        return sessionService.get(id, request, response);
    }

    @CrossOrigin(origins = "http://test1.dxy.net", maxAge = 3600,methods = {RequestMethod.GET},allowCredentials = "true")
    @RequestMapping(value = "/cors/login/{id}", method = RequestMethod.GET)
    public ResponsePacket getCorsLogin(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        return sessionService.get(id, request, response);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponsePacket get(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        return sessionService.get(id, request, response);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponsePacket post(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        return sessionService.post(id, request, response);
    }
}
