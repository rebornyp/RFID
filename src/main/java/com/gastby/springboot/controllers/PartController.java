package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.Part2Mapper;
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
public class PartController {

    @Autowired
    Part2Mapper partMapper;

    @GetMapping("/part")
    public String queryParts(Model model) {
        List<Part2> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "part/partList";
    }

    @GetMapping("/partAdd")
    public String addPart(Model model) {
        List<Part2> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "part/add";
    }

    @GetMapping("/partPosition")
    public String showPartPosition() {

        return "positions/part";
    }

    @PostMapping("/part/add")
    public String addOk(String name, String partId, String type, String position,
                        String birthDate, String info) {

        Part2 part = new Part2();
        part.setName(name);
        part.setPid(partId);
        part.setProduceDate(birthDate);
        part.setType(type);
        part.setProducer(position);
        part.setInfo(info);
        partMapper.insertPart(part);
        return "part/ok";
    }

    @GetMapping("/part/update")
    public String updatePart(Model model, String id, HttpSession httpSession) {
        int pid = Integer.parseInt(id);
        Part2 part = partMapper.queryPart(pid);
        model.addAttribute("part", part);
        httpSession.setAttribute("curPartId", id);
        return "part/updatePage";
    }

    @PostMapping("/part/updateOk")
    public String updatePartOk(HttpSession httpSession, String name, String partId, String type,
                               String position, String birthDate, String info) {
        String pid = (String) httpSession.getAttribute("curPartId");
        Integer id = Integer.parseInt(pid);
        Part2 part = partMapper.queryPart(id);
        part.setName(name);
        part.setPid(partId);
        part.setProducer(position);
        part.setType(type);
        part.setInfo(info);
        part.setProduceDate(birthDate);
        partMapper.updatePartById(part);
        return "part/ok";
    }

}
