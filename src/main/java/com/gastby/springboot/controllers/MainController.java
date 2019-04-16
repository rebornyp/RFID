package com.gastby.springboot.controllers;

import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.entities.Record;
import com.gastby.springboot.mapper.MonitorRecordMapper;
import com.gastby.springboot.utils.MyTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    MonitorRecordMapper monitorRecordMapper;

    @RequestMapping("/main")
    public String frontPage(Model model) {
        List<MonitorRecord> records = monitorRecordMapper.queryAllRecords();
        for (MonitorRecord m : records) {
            m.myTimeFormat = new MyTimeFormat(m.getStartTime());
        }
        Collections.sort(records, new Comparator<MonitorRecord >() {
            @Override
            public int compare(MonitorRecord o1, MonitorRecord o2) {
                return o1.myTimeFormat.compareTo(o2.myTimeFormat);
            }
        });
        MyTimeFormat base = null;
        HashMap<MyTimeFormat, Integer> hashMap = new HashMap<>();
        for (int i=0; i<records.size(); i++) {
            MyTimeFormat curTime = records.get(i).myTimeFormat;
            if (i == 0) {
                hashMap.put(curTime, 1);
                base = curTime;
            } else if (curTime.getYear() == base.getYear()
                    && curTime.getMonth() == base.getMonth()
                    && curTime.getDay() == base.getDay()) {
                hashMap.replace(base, hashMap.get(base) + 1);
            } else {
                hashMap.put(curTime, 1);
                base = curTime;
            }
        }
        List<MyTimeFormat> formats = new ArrayList<>(hashMap.keySet());
        Collections.sort(formats);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i<formats.size(); i++) {
            numbers.add(hashMap.get(formats.get(i)));
        }
        model.addAttribute("times", formats);
        model.addAttribute("numbers", numbers);
        return "front/main";
    }


    @RequestMapping("/success")
    public String success(Map<String, String> map) {
        map.put("hello", "gastby");
        return "success";
    }

}
