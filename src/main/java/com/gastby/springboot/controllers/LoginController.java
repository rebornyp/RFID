package com.gastby.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(String username, String password, Map<String, Object> map, HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        } else {
            map.put("msg", "用户名密码错误， 请重新输入");
            return "/login";
        }
    }

}
