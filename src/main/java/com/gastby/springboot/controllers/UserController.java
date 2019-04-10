package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.UserMapper;
import com.gastby.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
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
        user.setPassword(userPwd);
        user.setInfo(info);
        userMapper.insertUser(user);
        return "emp/ok";
    }

    @GetMapping("/emp/update")
    public String updatePart(Model model, String id, HttpSession httpSession) {
        int pid = Integer.parseInt(id);
        User user = userMapper.queryUserById(pid);
        model.addAttribute("user", user);
        httpSession.setAttribute("curUserId", id);
        return "emp/updatePage";
    }

    @PostMapping("/emp/updateOk")
    public String updatePartOk(HttpSession httpSession, String name, String gender, String level,
                               String userId, String mailBox, String userPwd, String info) {
        String tempid = (String) httpSession.getAttribute("curUserId");
        Integer id = Integer.parseInt(tempid);
        User user = userMapper.queryUserById(id);
        user.setInfo(info);
        user.setPassword(userPwd);
        user.setName(name);
        user.setMailBox(mailBox);
        user.setLevel(level);
        user.setGender(gender);
        user.setUserId(userId);
        userMapper.updateUserById(user);
        return "emp/ok";
    }
}
