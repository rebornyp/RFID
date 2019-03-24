package com.gastby.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MainController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        Object d = printPic();
        saveLocal(d);
        return "zscfasdfnice to meet you";
    }

    private void saveLocal(Object d) {

    }

    private Object printPic() {
        return new Object();
    }

    @RequestMapping("/success")
    public String success(Map<String, String> map) {
        map.put("hello", "gastby");
        return "success";
    }

}
