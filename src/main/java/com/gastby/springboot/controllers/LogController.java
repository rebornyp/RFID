package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.entities.Record;
import com.gastby.springboot.entities.TransportPojo;
import com.gastby.springboot.mapper.MonitorRecordMapper;
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
        System.out.println(list);
        return "log/info";
    }

}
