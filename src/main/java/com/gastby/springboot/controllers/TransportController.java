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

    String A = "KF-A", B = "ZJ-B", C = "ZZ-C";

    @GetMapping("/transport")
    public String showMap(Model model) {
        List<TransportPojo> list = transportMapper.queryBusyMissions();
        int A2B = 0, A2C = 0, B2A = 0, B2C = 0, C2A = 0, C2B = 0;
        String sh, eh;
        for (TransportPojo t : list) {
            sh = t.getStartHouse();
            eh = t.getEndHouse();
            if (sh.equals(A) && eh.equals(B)) A2B ++;
            else if (sh.equals(A) && eh.equals(C)) A2C ++;
            else if (sh.equals(B) && eh.equals(A)) B2A ++;
            else if (sh.equals(B) && eh.equals(C)) B2C ++;
            else if (sh.equals(C) && eh.equals(A)) C2A ++;
            else if (sh.equals(C) && eh.equals(B)) C2B ++;
        }
        model.addAttribute("a2b", A2B);
        model.addAttribute("a2c", A2C);
        model.addAttribute("b2a", B2A);
        model.addAttribute("b2c", B2C);
        model.addAttribute("c2a", C2A);
        model.addAttribute("c2b", C2B);
        return "transport/map";
    }

    @GetMapping("/trans")
    public String showAllTransportLists(Model model) {
        List<TransportPojo> missions = transportMapper.queryAllTransportMissions();
        model.addAttribute("missions", missions);
        return "transport/missions";
    }

    @GetMapping("/trans/path")
    public String showpartTransportLists(Model model, String s, String e) {
        List<TransportPojo> missions = transportMapper.queryMissionsByPath(s, e);
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
