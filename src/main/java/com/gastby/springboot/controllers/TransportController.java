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
        String a2b = "", b2a = "", a2c = "", c2a = "", b2c = "", c2b = "";
        for (TransportPojo t : list) {
            sh = t.getStartHouse();
            eh = t.getEndHouse();
            if (sh.equals(A) && eh.equals(B)) {
                A2B ++;
                a2b += t.getTid();
                a2b += " ";
            }
            else if (sh.equals(A) && eh.equals(C)) {
                A2C ++;
                a2c += t.getTid();
                a2c += " ";
            }
            else if (sh.equals(B) && eh.equals(A)) {
                B2A ++;
                b2a += t.getTid();
                b2a += " ";
            }
            else if (sh.equals(B) && eh.equals(C)) {
                B2C ++;
                b2c += t.getTid();
                b2c += " ";
            }
            else if (sh.equals(C) && eh.equals(A)) {
                C2A ++;
                c2a += t.getTid();
                c2a += " ";
            }
            else if (sh.equals(C) && eh.equals(B)) {
                C2B ++;
                c2b += t.getTid();
                c2b += " ";
            }
        }
        model.addAttribute("a2b", A2B);
        model.addAttribute("a2c", A2C);
        model.addAttribute("b2a", B2A);
        model.addAttribute("b2c", B2C);
        model.addAttribute("c2a", C2A);
        model.addAttribute("c2b", C2B);

        String info = "";
        if (A2B != 0) {
            info += "从 库房A 到 质检厂房B 的运输单数有 " + A2B + " 个，编号分别为" + a2b + ";\n";
        }
        if (B2A != 0) {
            info += "从 质检厂房B 到 库房A 的运输单数有 " + B2A + " 个，编号分别为" + b2a + ";\n";
        }
        if (A2C != 0) {
            info += "从 库房A 到 总装厂房C 的运输单数有 " + A2C + " 个，编号分别为" + a2c + ";\n";
        }
        if (C2A != 0) {
            info += "从 总装厂房C 到 库房A 的运输单数有 " + C2A + " 个，编号分别为" + c2a + ";\n";
        }
        if (B2C != 0) {
            info += "从 质检厂房B 到 总装厂房C 的运输单数有 " + B2C + " 个，编号分别为" + b2c + ";\n";
        }
        if (C2B != 0) {
            info += "从 总装厂房C 到 质检厂房B 的运输单数有 " + C2B + " 个，编号分别为" + c2b + ";\n";
        }
        model.addAttribute("info", info);


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
