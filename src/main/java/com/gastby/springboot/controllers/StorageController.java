package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.House;
import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.HouseMapper;
import com.gastby.springboot.mapper.MonitorRecordMapper;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.TagMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showWareHouse(Model model, @RequestParam(value = "curHouseId", required = true) String curHouseId) {

        List<House> houses = houseMapper.queryAllHouse();
        model.addAttribute("houses", houses);

        String curHouseName = houseMapper.queryHouseNameById(curHouseId);
        List<Part2> parts = partMapper.queryPartsByHouseName(curHouseName);
        for (int i=0; i<parts.size(); i++) {
            parts.get(i).setId(i+1);
        }
        model.addAttribute("parts", parts);
        model.addAttribute("curHouseId", curHouseId);
        model.addAttribute("curHouseName", curHouseName);

        String curReaderId = houseMapper.queryReaderById(curHouseId);
        model.addAttribute("curReaderId", curReaderId);
        List<MonitorRecord> records = monitorRecordMapper.queryAllRecordsByReaderId(curReaderId);
        help(records);
        model.addAttribute("records", records);

        return "storage/index";
    }

    @GetMapping("/storage2")
    public String showWareHouse2(Model model, String curHouseName) {
        List<Part2> parts = partMapper.queryPartsByHouseName(curHouseName);
        for (int i=0; i<parts.size(); i++) {
            parts.get(i).setId(i+1);
        }
        String curHouseId = houseMapper.queryHouseIdByName(curHouseName);
        List<House> houses = houseMapper.queryAllHouse();
        model.addAttribute("houses", houses);
        model.addAttribute("parts", parts);
        model.addAttribute("curHouseId", curHouseId);
        model.addAttribute("curHouseName", curHouseName);
        String curReaderId = houseMapper.queryReaderById(curHouseId);
        model.addAttribute("curReaderId", curReaderId);
        List<MonitorRecord> records = monitorRecordMapper.queryAllRecordsByReaderId(curReaderId);
        help(records);
        model.addAttribute("records", records);
        return "storage/index";
    }

    private void help(List<MonitorRecord> records) {
        for (MonitorRecord m : records) {
            String partId = tagMapper.queryPartIdByTagId(m.getTagId());
            String partName = partMapper.queryPartNameById(partId);
            m.setPartId(partId);
            m.setPartName(partName);
        }
    }

}
