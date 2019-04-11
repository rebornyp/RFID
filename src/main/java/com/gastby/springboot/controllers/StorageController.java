package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.House;
import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.HouseMapper;
import com.gastby.springboot.mapper.Part2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StorageController {
    @Autowired
    Part2Mapper partMapper;

    @Autowired
    HouseMapper houseMapper;


    @GetMapping("/storage")
    public String showWareHouse(Model model, String houseId) {
        String houseName = houseMapper.queryHouseNameById(houseId);
        List<Part2> parts = partMapper.queryPartsByHouseId(houseName);
        model.addAttribute("parts", parts);
        return "storage/index";
    }
}
