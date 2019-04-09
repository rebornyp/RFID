package com.gastby.springboot.controllers;

import com.gastby.springboot.mapper.UserMapper;
import com.gastby.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/userList")
    public String queryEmps(Model model) {
        List<User> users = userMapper.queryAllUsers();
        model.addAttribute("emps", users);
        return "emp/list";
    }


    @GetMapping("/emp")
    public String addEmp() {
        return "emp/add";
    }


    @PostMapping("/emp/add")
    public String addOk(String name, String userId, String userPwd,
                        String mailBox, String gender, String level, String info) {
        User user = new User();
        user.setGender(gender);
        user.setLevel(level);
        user.setUserId(userId);
        user.setMailBox(mailBox);
        user.setName(name);
        user.setUserPwd(userPwd);
        user.setInfo(info);
        userMapper.insertUser(user);
        return "emp/ok";
    }
}
