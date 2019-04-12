package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.House;
import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.HouseMapper;
import com.gastby.springboot.mapper.MonitorRecordMapper;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.TagMapper;
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

    @Autowired
    MonitorRecordMapper monitorRecordMapper;

    @Autowired
    TagMapper tagMapper;


    @GetMapping("/storage")
    public String showWareHouse(Model model, String curHouseId) {

        List<House> houses = houseMapper.queryAllHouse();
        model.addAttribute("houses", houses);

        String curHouseName = houseMapper.queryHouseNameById(curHouseId);
        List<Part2> parts = partMapper.queryPartsByHouseName(curHouseName);
        model.addAttribute("parts", parts);
        model.addAttribute("cur", curHouseId);

        String curReaderId = houseMapper.queryReaderById(curHouseId);
        List<MonitorRecord> records = monitorRecordMapper.queryAllRecordsByReaderId(curReaderId);
        for (MonitorRecord m : records) {
            String partId = tagMapper.queryPartIdByTagId(m.getTagId());
            String partName = partMapper.queryPartNameById(partId);
            m.setPartId(partId);
            m.setPartName(partName);
        }
        model.addAttribute("records", records);

        return "storage/index";
    }
}
