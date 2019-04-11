package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.entities.PartList;
import com.gastby.springboot.entities.TransportPojo;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.PartListMapper;
import com.gastby.springboot.mapper.TransportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TransportController {

    @Autowired
    TransportMapper transportMapper;

    @Autowired
    PartListMapper partListMapper;

    @GetMapping("/transport")
    public String showMap() {
        return "transport/map";
    }

    @GetMapping("/trans")
    public String showAllTransportLists(Model model) {
        List<TransportPojo> missions = transportMapper.queryAllTransportMissions();
        model.addAttribute("missions", missions);
        return "transport/missions";
    }

    @GetMapping("/trans/MissionAdd")
    public String addMission(Model model) {
        return "transport/add";
    }

    @PostMapping("/trans/add")
    public String missonAddOk(String tid, String listId, String readerId, String startTime,
                              String endTime, String startHouse, String endHouse,
                              String worker, String info) {
        TransportPojo trans = new TransportPojo();
        trans.setTid(tid);
        trans.setListId(listId);
        trans.setReaderId(readerId);
        trans.setStartTime(startTime);
        trans.setStartHouse(startHouse);
        trans.setEndTime(endTime);
        trans.setEndHouse(endHouse);
        trans.setInfo(info);
        trans.setWorker(worker);
        transportMapper.insertTransport(trans);
        return "/transport/ok";
    }

    @GetMapping("/trans/missonPartList")
    public String missionList(Model model, String id) {
        List<Part2> parts = partListMapper.queryPartListById(id);
        model.addAttribute("parts", parts);
        return "transport/partList";
    }


}
