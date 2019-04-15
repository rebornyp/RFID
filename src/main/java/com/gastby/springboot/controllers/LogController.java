package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.entities.Record;
import com.gastby.springboot.entities.TransportPojo;
import com.gastby.springboot.mapper.MonitorRecordMapper;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.TagMapper;
import com.gastby.springboot.mapper.TransportMapper;
import com.gastby.springboot.utils.MyTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class LogController {

    @Autowired
    MonitorRecordMapper monitorRecordMapper;

    @Autowired
    TransportMapper transportMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    Part2Mapper part2Mapper;

    @GetMapping("/log")
    public String queryLog(Model model) {
        List<MonitorRecord> monitorRecords = monitorRecordMapper.queryAllRecords();
        List<TransportPojo> transportPojos = transportMapper.queryAllTransportMissions();
        List<Record> list = new ArrayList<>();
        for (MonitorRecord m : monitorRecords) list.add(m);
        for (TransportPojo m : transportPojos) list.add(m);
        Collections.sort(list, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return new MyTimeFormat(o1.startTime()).compareTo(new MyTimeFormat(o2.startTime()));
            }
        });
        List<String> records = new ArrayList<>();
        int i = 1;
        for (Record r : list) {
            if (r instanceof TransportPojo)
                records.add("第"+i++ +"条记录："+r.toString());
            else {
                MonitorRecord m = (MonitorRecord) r;
                String partId = tagMapper.queryPartIdByTagId(m.getTagId());
                String partName = part2Mapper.queryPartNameById(partId);
                records.add("第"+i++ +"条记录："+r.toString() + " 零件名称：" + partName + "；");
            }
        }
        model.addAttribute("records", records);
        return "log/info";
    }

}
