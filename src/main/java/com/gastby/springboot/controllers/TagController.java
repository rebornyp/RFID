package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.entities.Tag;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.TagMapper;
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
public class TagController {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    Part2Mapper partMapper;

    @GetMapping("/tags")
    public String queryTags(Model model) {
        List<Tag> tags = tagMapper.queryAllTags();
        model.addAttribute("tags", tags);
        return "tag/tagList";
    }

    @GetMapping("/tags/bind")
    public String binding(Model model, String tid, String id, HttpSession httpSession) {
        List<Part2> parts = partMapper.queryUnBindTags();
        model.addAttribute("parts", parts);
        httpSession.setAttribute("currentTag", tid);
        httpSession.setAttribute("currentTagId", id);
        return "tag/bindingPage";
    }

    @GetMapping("/tags/bindOk")
    public String bindOk(String pid, String partId, HttpSession httpSession) {
        String tempId = (String)httpSession.getAttribute("currentTagId");
        Integer id = Integer.parseInt(tempId);
        String tid = (String) httpSession.getAttribute("currentTag");
        partMapper.updateTagInfo(Integer.parseInt(pid), tid);
        tagMapper.updatePartInfo(id, partId);
        return "tag/ok";
    }

}
